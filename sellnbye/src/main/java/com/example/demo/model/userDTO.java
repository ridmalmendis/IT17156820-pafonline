package com.example.demo.model;

import com.example.demo.conrollers.enums.UserType;

import javax.persistence.*;

@Entity
@Table(name = "usertb")
public class userDTO {


    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_ID")
    private String id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "user_type")
    private UserType type;
    @Column(name = "user_mail")
    private String email;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_pwd")
    private String password;

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }





}
