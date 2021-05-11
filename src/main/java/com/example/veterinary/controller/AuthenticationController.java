package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody UserCredentialsDto userCredentials){
        return authenticationService.signUp(userCredentials);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredentialsDto userCredentialsDto){
        return authenticationService.getToken(userCredentialsDto);
    }
}
