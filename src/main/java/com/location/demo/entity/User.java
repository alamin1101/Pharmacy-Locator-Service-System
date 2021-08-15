package com.location.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor

@Entity
public class User {

    public static final String ROLE_USER = "ROLE_USER";

    @Id
    private String username;
    private String email;
    private String address;
    private String password;
    @Transient
    private String confirmPassword;
    private String role;

    public User() {
    }

    public User(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

}
