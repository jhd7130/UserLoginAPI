package com.example.sessionClustering.ctrl;

import com.example.sessionClustering.dto.LoginDTO;
import com.example.sessionClustering.entity.LoginEntity;
import com.example.sessionClustering.service.LoginService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    public final LoginService loginService;

    public UserLoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/login/getLoginForm")
    public String opnLoginPage(Model model){
        model.addAttribute("username", "Logan");
        return "login/signin";
    }

    @PostMapping("login/tryToLogin")
    public String tryLogin(LoginDTO form){

        LoginEntity login = form.toEntity();







        return"";
    }
}
