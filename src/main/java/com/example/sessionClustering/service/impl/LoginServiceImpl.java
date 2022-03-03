package com.example.sessionClustering.service.impl;

import com.example.sessionClustering.repository.LoginRepository;
import com.example.sessionClustering.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    public final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
    }



}
