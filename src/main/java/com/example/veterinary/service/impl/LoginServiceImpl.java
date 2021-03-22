package com.example.veterinary.service.impl;

import com.example.veterinary.dto.UserCredentialsDto;
import com.example.veterinary.dto.user.*;
import com.example.veterinary.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Object getAccountAccess(UserCredentialsDto userCredentialsDto) {
        //TODO: logic for selecting user's account
        return new ClinicStaffDto("1", UserType.ADMIN,"john","doe","head of clinic");
    }
}
