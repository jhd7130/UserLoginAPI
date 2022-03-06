package com.example.sessionClustering.repository;


import com.example.sessionClustering.dto.MemberDTO;
import com.example.sessionClustering.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<MemberEntity,String> {
        MemberEntity findByEmail(String email);

        MemberDTO findByUserId(String userId);
}
