package com.example.sessionClustering.service.impl;

import com.example.sessionClustering.dto.LoginDTO;
import com.example.sessionClustering.dto.MemberDTO;
import com.example.sessionClustering.entity.Member;
import com.example.sessionClustering.repository.MemberRepository;
import com.example.sessionClustering.service.LoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    public final MemberRepository memberRepository;

    public LoginServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    @Transactional
    public MemberDTO memberLogin(LoginDTO loginDTO) throws Exception {
        System.out.println("여기까지 찍힘 여기는 서비스 ============== " + loginDTO);
        //email정보로 해당 email이 존재하는지 체크
        if(memberRepository.findByEmail(loginDTO.getEmail()) == null){
            MemberDTO memberDTO = new MemberDTO();
            return memberDTO;
        }
        Member memberEntity = memberRepository.findByEmail(loginDTO.getEmail());

        if(memberEntity.getPassword().equals(loginDTO.getPassword())){
            MemberDTO memberDTO = new MemberDTO(memberEntity);
            return memberDTO;
        }

        MemberDTO memberDTO = new MemberDTO();
        return memberDTO;
    }

    @Override
    public MemberDTO checkUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }
}