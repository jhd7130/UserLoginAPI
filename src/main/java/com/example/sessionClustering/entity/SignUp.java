package com.example.sessionClustering.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SignUp {

    @Id
    @GeneratedValue
    private Long Id;

    @Column
    private String userNm;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String userId;
}
