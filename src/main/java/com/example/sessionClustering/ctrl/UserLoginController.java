package com.example.sessionClustering.ctrl;

import com.example.sessionClustering.dto.LoginDTO;
import com.example.sessionClustering.dto.MemberDTO;
import com.example.sessionClustering.entity.LoginEntity;
import com.example.sessionClustering.repository.MemberRepository;
import com.example.sessionClustering.security.TokenProvider;
import com.example.sessionClustering.service.LoginService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class UserLoginController {

    public final LoginService loginService;

    public final TokenProvider tokenProvider;

    public UserLoginController(LoginService loginService,TokenProvider tokenProvider ){
        this.loginService = loginService;
        this.tokenProvider = tokenProvider;
    }

    @GetMapping("/login/getLoginForm")
    public String loginPage(@CookieValue(name="userId",required = false) String userId, Model model,String token){
        //저장된 쿠키 정보 미존재시 로그인페이지로 이동
        System.out.println(userId);

        if(userId == null){
            // template을 찾지않고 String만 반환하는 문제 발생
            return "login/loginPage";
        }

        // 쿠키에 있는 id로 조회
        // 미존재시 로그인 페이지로 이동
        MemberDTO member = loginService.checkUserId(userId);
        if(member == null){
            return "login/loginPage";
        }

        // 쿠키 userId와 같은 Id를 가진 정보 존재시 바로 메인페이지로 이동
        model.addAttribute("user",member);
        return "메인페이지";
    }

    @GetMapping("/login/getLoginFormToken")
    public String loginPageUseToken(Model model,@RequestParam(value = "token") String token){

        //token이 없는 경우에

          if(tokenProvider.validateToken(token)) {
              Claims claims = tokenProvider.getInformation(token);

              //일단 토큰을 검증하고나서 토큰이 제대로 풀리면
              // 클레임에 있는 정보를 가지고 다시한번 조회 를 통해 더블체크를 하면 더 좋지 않을까?
              String email = (String) claims.get("userId");
              String password = (String) claims.get("password");
              System.out.println(email + "   " + password);
              return "로그인완료페이지";
          }
        return "메인페이지";
    }

    // 로그인 시도 -- 쿠키를 이용한 로그인
    @PostMapping("/login/tryToLogin")
    public String tryLogin(@RequestBody  LoginDTO loginDTO,
                           BindingResult bindingResult, HttpServletResponse response, String token) throws Exception{
            System.out.println(loginDTO.toString());
             // 화면에서 받은 로그인 정보로 로그인이 가능한지 먼저 체크
            MemberDTO member = loginService.memberLogin(loginDTO);
            System.out.println(member.toString());

            //정보가 틀려 가져오지 못했다면 알림 제공
            if(member.getUserId() == null){
                bindingResult.reject("loginFail", "아이디또는 비밀번호가 맞지 않습니다.");
                return "아이디또는 비밀번호가 맞지 않습니다";
            }

            if(token == null){
              String tokken = tokenProvider.createToken(loginDTO.getEmail(),loginDTO.getPassword());
              response.addHeader("toekn",tokken);
            }

            // 로그인 정보가 모두 맞는다면 쿠키객체에 userId 저장하고 response객체에 해당 쿠키 추가 후 메인페이지로 이동
           Cookie idCookie = new Cookie("userId",member.getUserId());
           response.addCookie(idCookie);



        return"성공페이지";
    }

    @PostMapping("/login/tryToLoginToken")
    public String tryLoginUseToken(@RequestBody  LoginDTO loginDTO,
                           BindingResult bindingResult, HttpServletResponse response, String token) throws Exception{

        // 화면에서 받은 로그인 정보로 로그인이 가능한지 먼저 체크
        MemberDTO member = loginService.memberLogin(loginDTO);


        //정보가 틀려 가져오지 못했다면 알림 제공
        if(member.getUserId() == null){
            bindingResult.reject("loginFail", "아이디또는 비밀번호가 맞지 않습니다.");
            return "아이디또는 비밀번호가 맞지 않습니다";
        }

        if(token == null){
            String tokken = tokenProvider.createToken(loginDTO.getEmail(),loginDTO.getPassword());
            response.addHeader("toekn",tokken);
        }

        return"성공페이지";
    }


    // 로그아웃 버튼 클릭시 쿠키내부의 userId 값 삭제 후 로그인 페이지로 이동
    // 로그인 페이지를 여는 메서드에서는 쿠키의 userId값을 확인 후 없으면 로그인 페이지로 돌려준다.
    @PostMapping("/logout")
    public String logout(HttpServletResponse response, @CookieValue(name="userId",required = false) String userId){
        expiredCookie(response,"userId");
        return "logout 페이지";
    }


    private void expiredCookie(HttpServletResponse response, String cookieName){
        Cookie cookie = new Cookie(cookieName,null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
