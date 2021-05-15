package com.example.veterinary.service;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.exception.NoSuchRowException;

public interface UserService {
    void create(UserCredentialsDto userCredentialsDto);

    boolean isUserExistByEmail(String email) throws NoSuchRowException;
}
