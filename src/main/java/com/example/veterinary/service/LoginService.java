package com.example.veterinary.service;

import com.example.veterinary.domain.dto.login.UserCredentialsDto;

public interface LoginService {
    Object getAccountAccess(UserCredentialsDto userCredentialsDto);
}
