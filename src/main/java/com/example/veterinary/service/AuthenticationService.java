package com.example.veterinary.service;

import com.example.veterinary.domain.dto.authentication.AuthResponseDto;
import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;

import java.util.UUID;

public interface AuthenticationService {
    AuthResponseDto signUp(UserCredentialsDto userCredentialsDto, UUID adminId);

    AuthResponseDto signIn(UserCredentialsDto userCredentialsDto);
}
