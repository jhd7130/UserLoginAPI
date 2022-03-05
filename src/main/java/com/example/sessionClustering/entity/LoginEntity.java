package com.example.sessionClustering.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LoginEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String email;

    @Column
    private String password;

    public LoginEntity(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
