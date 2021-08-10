package com.location.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pharmacy {

    @Id
    private String licenceNo;
    private String pName;
    private String location;
    private String latitude;
    private String longtitude;


}
