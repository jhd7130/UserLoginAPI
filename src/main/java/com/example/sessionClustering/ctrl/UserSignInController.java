package com.example.sessionClustering.ctrl;


import com.example.sessionClustering.service.SignUpService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSignInController {

    public final SignUpService signUpService;

    public UserSignInController(SignUpService signUpService){
        this.signUpService = signUpService;
    }
}
