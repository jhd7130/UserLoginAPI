package com.example.sessionClustering.service.impl;

import com.example.sessionClustering.dto.SignUpDTO;
import com.example.sessionClustering.entity.SignUpEntity;
import com.example.sessionClustering.repository.SignUpRepository;
import com.example.sessionClustering.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    SignUpRepository signUpRepository;

    @Autowired
    public SignUpServiceImpl( SignUpRepository signUpRepository){
        super();
        this.signUpRepository = signUpRepository;
    }

    @Override
    public SignUpEntity join(SignUpEntity signUpEntity) {
        System.out.println(signUpEntity.toString());
        return  signUpRepository.save(signUpEntity);


    }
}
