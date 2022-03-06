package com.example.sessionClustering.dto;

import com.example.sessionClustering.entity.LoginEntity;
import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String password;

    public LoginEntity toEntity(){ return new LoginEntity(null,email,password);}
}
