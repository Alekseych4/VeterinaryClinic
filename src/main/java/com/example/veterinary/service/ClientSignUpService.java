package com.example.veterinary.service;

import com.example.veterinary.dto.patient.PatientCardDto;
import com.example.veterinary.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.dto.user.LoggedClientDto;
import com.example.veterinary.dto.user.LoggedClientNoIdDto;

public interface ClientSignUpService {
    LoggedClientDto createUser(LoggedClientNoIdDto clientDto);

    PatientCardDto createPatientCard(PatientCardNoIdDto patientCardNoIdDto);
}
