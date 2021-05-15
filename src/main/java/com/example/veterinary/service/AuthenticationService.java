package com.example.veterinary.service;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;

import java.util.UUID;

public interface AuthenticationService {
    String signUp(UserCredentialsDto userCredentialsDto, UUID adminId);

    String signIn(UserCredentialsDto userCredentialsDto);
}
