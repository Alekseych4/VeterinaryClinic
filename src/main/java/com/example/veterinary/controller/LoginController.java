package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.login.UserCredentialsDto;
import com.example.veterinary.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    public Object getAccountAccess(@RequestBody UserCredentialsDto userCredentials){
        return loginService.getAccountAccess(userCredentials);
    }

//    @GetMapping("/sign-up")
//    public LoggedClientDto clientSignUp(){
//        return
//    }

}
