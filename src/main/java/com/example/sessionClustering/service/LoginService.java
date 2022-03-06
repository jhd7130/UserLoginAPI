package com.example.sessionClustering.service;


import com.example.sessionClustering.dto.LoginDTO;
import com.example.sessionClustering.dto.MemberDTO;
import com.example.sessionClustering.repository.MemberRepository;

public interface LoginService {

    MemberDTO memberLogin(LoginDTO loginDTO) throws Exception;

    MemberDTO checkUserId(String userId);
}
