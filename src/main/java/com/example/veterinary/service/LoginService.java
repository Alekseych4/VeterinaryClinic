package com.example.veterinary.service;

import com.example.veterinary.dto.UserCredentialsDto;
import com.example.veterinary.dto.user.*;

public interface LoginService {
    Object getAccountAccess(UserCredentialsDto userCredentialsDto);
}
