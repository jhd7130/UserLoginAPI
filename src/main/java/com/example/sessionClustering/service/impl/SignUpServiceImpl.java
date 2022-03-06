package com.example.sessionClustering.service.impl;

import com.example.sessionClustering.entity.Member;
import com.example.sessionClustering.repository.MemberRepository;
import com.example.sessionClustering.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService {

    MemberRepository signUpRepository;

    @Autowired
    public SignUpServiceImpl( MemberRepository signUpRepository){
        super();
        this.signUpRepository = signUpRepository;
    }

    @Override
    public Member join(Member signUpEntity) {
        System.out.println(signUpEntity.toString());
        return  signUpRepository.save(signUpEntity);


    }
}
