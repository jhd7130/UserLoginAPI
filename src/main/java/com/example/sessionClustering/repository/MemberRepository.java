package com.example.sessionClustering.repository;


import com.example.sessionClustering.dto.MemberDTO;
import com.example.sessionClustering.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,String> {
        Member findByEmail(String email);

        MemberDTO findByUserId(String userId);
}
