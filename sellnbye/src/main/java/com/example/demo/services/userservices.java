package com.example.demo.services;


import com.example.demo.conrollers.User;
import com.example.demo.model.userDTO;

import java.util.List;

public interface userservices {

    List<userDTO> findallusers();

    String updateUser(userDTO newuserdata);

    void insertUser(userDTO user);

   void deleteUser(String username) throws IllegalAccessException;
}
