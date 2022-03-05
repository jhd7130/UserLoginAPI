package com.example.sessionClustering.ctrl;


import com.example.sessionClustering.dto.SignUpDTO;
import com.example.sessionClustering.entity.SignUpEntity;
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
    public SignUpEntity saveMember(@RequestBody SignUpEntity signUpEntity){

        return signUpService.join(signUpEntity);
      //  return signUpService.join(signUpEntity);
    }
}
