package com.example.sessionClustering.service;

import com.example.sessionClustering.entity.MemberEntity;

public interface SignUpService {

    MemberEntity join(MemberEntity signUpEntity);
}
