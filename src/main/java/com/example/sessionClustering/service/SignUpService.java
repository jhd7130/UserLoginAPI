package com.example.sessionClustering.service;

import com.example.sessionClustering.dto.SignUpDTO;
import com.example.sessionClustering.entity.SignUpEntity;

public interface SignUpService {

    SignUpEntity join(SignUpEntity signUpEntity);
}
