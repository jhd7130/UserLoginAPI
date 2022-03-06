package com.example.sessionClustering.ctrl;


import com.example.sessionClustering.entity.Member;
import com.example.sessionClustering.service.SignUpService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserSignInController {

    public final SignUpService signUpService;

    public UserSignInController(SignUpService signUpService){
        this.signUpService = signUpService;
    }


    @GetMapping(value = "/user/memberPage")
    public String getPage(){
        return "/articles/new";
    }

    @PostMapping(value = "/user/member")
    public Member saveMember(@RequestBody Member signUpEntity) {
        return signUpService.join(signUpEntity);
      //  return signUpService.join(signUpEntity);
    }
}
