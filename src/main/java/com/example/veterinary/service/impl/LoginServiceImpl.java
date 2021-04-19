package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.login.UserCredentialsDto;
import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.UserType;
import com.example.veterinary.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Object getAccountAccess(UserCredentialsDto userCredentialsDto) {
        //TODO: logic for selecting user's account
        return null;
    }
}
