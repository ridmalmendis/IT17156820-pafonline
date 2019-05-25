package com.example.demo.services.impl;

import com.example.demo.conrollers.enums.UserType;
import com.example.demo.model.userDTO;
import com.example.demo.repositories.userrepo;
import com.example.demo.services.userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import org.apache.commons.lang.RandomStringUtils;

import java.util.List;

@Service
public class userimpl implements userservices {

   @Autowired
    private userrepo userrepo;

    @Override
    public List<userDTO> findallusers() {
        List<userDTO> allusers = userrepo.findAll();
        return allusers;
    }



    @Override
    public String updateUser(userDTO newuserdata) {

        String msg = null;
        if(newuserdata.getId()!=null){

            userrepo.save(newuserdata);
            msg = "updated";
        }
        else{
            msg = "error";
        }

        return msg;
    }
    @Override
    public void insertUser(userDTO user) {

        if(user.getFirstname() == null || user.getFirstname().isEmpty() || user.getLastname() == null
                || user.getLastname().isEmpty() || user.getEmail() == null || user.getEmail().isEmpty()
                || user.getType() == null) {
            throw new IllegalArgumentException("User must have a First Name, Last Name and a Email");
        } else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String username = user.getFirstname().concat(user.getLastname()).toLowerCase();
            user.setUsername(username);
            user.setPassword(generatePassword());

            if(user.getType() == UserType.seller) {
                user.setId("SEL" + timestamp.getTime());

            } else {
                user.setId("BUY" + timestamp.getTime());
            }
            userrepo.save(user);

        }


    }

    @Override
    public void deleteUser(String username) throws IllegalAccessException {


        if(username.isEmpty()) {
            throw new IllegalArgumentException("Username is not provided to delete the user");
       }

       userDTO user = getUserByUsername(username);
        userrepo.delete(user);


    }
   private userDTO getUserByUsername(String username) throws IllegalAccessException {
        List<userDTO> userDTOList1 = userrepo.findByUsername(username);

       if(userDTOList1 == null || userDTOList1.size() == 0) {
            throw new IllegalAccessException(username + ", Invalid username");
       }
        return userDTOList1.get(0);
    }
    private String generatePassword() {
        return RandomStringUtils.random(10,true,true);
    }

}
