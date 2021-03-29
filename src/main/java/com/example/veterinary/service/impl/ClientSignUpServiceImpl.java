package com.example.veterinary.service.impl;

import com.example.veterinary.dto.user.LoggedClientDto;
import com.example.veterinary.dto.user.LoggedClientNoIdDto;
import com.example.veterinary.service.ClientSignUpService;
import org.springframework.stereotype.Service;

@Service
public class ClientSignUpServiceImpl implements ClientSignUpService {

    @Override
    public LoggedClientDto createUser(LoggedClientNoIdDto clientDto) {
        return new LoggedClientDto(generateId(), clientDto.getName(), clientDto.getSurname());
    }

    private String generateId(){
        return "testId";
    }
}
