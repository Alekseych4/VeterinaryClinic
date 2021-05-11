package com.example.veterinary.service;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;

public interface AuthenticationService {
    String signUp(UserCredentialsDto userCredentialsDto);

    String getToken(UserCredentialsDto userCredentialsDto);
}
