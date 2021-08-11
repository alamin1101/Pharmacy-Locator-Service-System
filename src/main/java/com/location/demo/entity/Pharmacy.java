package com.location.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerators;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pharmacy {

    @Id
    private String licenseNo;
    private String pName;
    private String address;
    private String phone;
    private String email;
    private float latitude;
    private float longitude;



}
