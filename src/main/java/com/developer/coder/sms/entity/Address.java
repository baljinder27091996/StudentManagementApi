package com.developer.coder.sms.entity;
import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;

    // Optional: if you want bi-directional mapping
    @OneToOne(mappedBy = "address")
    private Student student;

    // getters and setters
}
