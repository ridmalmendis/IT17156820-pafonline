package com.example.demo.repositories;

import com.example.demo.conrollers.enums.UserType;
import com.example.demo.model.userDTO;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface userrepo extends JpaRepository<userDTO,String> {
     List<userDTO> findByUsername(String username) ;


     List<userDTO> findByType(UserType type);
}
