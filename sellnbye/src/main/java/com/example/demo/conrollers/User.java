package com.example.demo.conrollers;

import com.example.demo.model.userDTO;
import com.example.demo.services.userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User {

    @Autowired
    private userservices userservices;

    @GetMapping("/all")
    public List<userDTO> alluser(){

        return userservices.findallusers();
    }

    @PutMapping("/update")
    public String updateuser(@RequestBody userDTO newuserdata){

      return userservices.updateUser(newuserdata);

    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<String> userRegistration(@RequestBody userDTO user) {

        try {
            if(user != null) {
                userservices.insertUser(user);
                return new ResponseEntity<>("New User is Registered.", HttpStatus.CREATED);
            }
        } catch(IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("User Object is Empty", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteUser/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable String username) {

        try {
            if(username != null) {
                userservices.deleteUser(username);
                return new ResponseEntity<>("User is Deleted.", HttpStatus.OK);
          }
        } catch(IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch(IllegalAccessException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Username is getting Null.", HttpStatus.NO_CONTENT);
    }

}
