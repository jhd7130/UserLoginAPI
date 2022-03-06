package com.example.sessionClustering.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class LoginEntity {

    @Id
    @GeneratedValue
    private Long id; // ID는 자동으로 생성되는데 어떻게 찾지?? 이걸로 찾으면 안되고 EMAIL로 찾아야함 방법찾기

    @Column
    private String email;

    @Column
    private String password;

    public LoginEntity(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
