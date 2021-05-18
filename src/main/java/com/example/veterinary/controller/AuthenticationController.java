package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.authentication.AuthResponseDto;
import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public AuthResponseDto signUp(@RequestBody UserCredentialsDto userCredentials,
                         @RequestParam(name = "id", required = false) UUID adminId){
        return authenticationService.signUp(userCredentials, adminId);
    }

    @PostMapping("/sign-in")
    public AuthResponseDto signIn(@RequestBody UserCredentialsDto userCredentialsDto){
        return authenticationService.signIn(userCredentialsDto);
    }
}
