package com.example.veterinary.service;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;

public interface UserService {
    void create(UserCredentialsDto userCredentialsDto);

    boolean isUserExistByEmail(String email);
}
