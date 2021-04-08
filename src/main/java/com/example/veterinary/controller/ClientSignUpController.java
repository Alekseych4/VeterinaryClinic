package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.domain.dto.user.LoggedClientDto;
import com.example.veterinary.domain.dto.user.LoggedClientNoIdDto;
import com.example.veterinary.service.ClientSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/sign-up")
public class ClientSignUpController {
    private final ClientSignUpService clientSignUpService;

    @PostMapping
    public LoggedClientDto createUser(@RequestBody LoggedClientNoIdDto loggedClientDto){
        return clientSignUpService.createUser(loggedClientDto);
    }

    @PostMapping(value = "/card")
    public PatientCardDto createPatientCard(@RequestBody PatientCardNoIdDto patientCardNoIdDto){
        return clientSignUpService.createPatientCard(patientCardNoIdDto);
    }
}
