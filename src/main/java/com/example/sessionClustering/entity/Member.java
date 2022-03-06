package com.example.sessionClustering.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Member")
public class Member implements Serializable {

    private static final long serialVersionUID=2004020003L;

    @Id
    @GeneratedValue(generator = "USER_GENERATOR")
    @GenericGenerator(name = "USER_GENERATOR", strategy = "uuid")

    private String userId;

    @Column(name = "userNm")
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
