package com.example.sessionClustering.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class MemberEntity {

    @Id
    @GeneratedValue(generator = "USER_GENERATOR")
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")
    private String userId;

    @Column
    private String userNm;

    @Column
    private String phone;

    @Column(length = 1024)
    private String address;

    @Column
    private String email;

    @Column
    private String password;

}
