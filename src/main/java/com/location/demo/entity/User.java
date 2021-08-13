package com.location.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Setter
@Getter
@AllArgsConstructor

@Entity
public class User {

    @Id
    private String username;
    private String email;
    private String password;
    @Transient
    private String confirmPassword;
    private String role;

    public User() {

    }
}
