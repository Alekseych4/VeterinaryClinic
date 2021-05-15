package com.example.veterinary.config;

import com.example.veterinary.controller.AuthenticationController;
import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.exception.NoSuchItemException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class StartConfig {
    private final AuthenticationController authenticationController;
    @Value("${admin.email}")
    private String email;
    @Value("${admin.password}")
    private String password;
    @Value("${admin.role}")
    private String role;

    @PostConstruct
    public void addAdmin(){
        UserRole userRole = UserRole.valueOf(role);
        UserCredentialsDto userCredentialsDto = new UserCredentialsDto(email, password, userRole);

        try {
            authenticationController.getToken(userCredentialsDto);
        } catch (NoSuchItemException e){
            authenticationController.signUp(userCredentialsDto);
        }

    }
}
