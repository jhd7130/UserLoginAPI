package com.example.sessionClustering.dto;

import com.example.sessionClustering.entity.Member;
import lombok.Data;

@Data
public class MemberDTO {

    private String userNm;
    private String phone;
    private String address;
    private String email; // this is same with LoginID
    private String password;
    private String userId;

    public MemberDTO(){}
    public MemberDTO(Member signUpEntity){
        this.email = signUpEntity.getEmail();
        this.phone = signUpEntity.getPhone();
        this.address = signUpEntity.getAddress();
        this.password = signUpEntity.getPassword();
        this.userId = signUpEntity.getUserId();
    }
}
