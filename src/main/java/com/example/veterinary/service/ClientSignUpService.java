package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.domain.dto.user.LoggedClientDto;
import com.example.veterinary.domain.dto.user.LoggedClientNoIdDto;

public interface ClientSignUpService {
    LoggedClientDto createUser(LoggedClientNoIdDto clientDto);

    PatientCardDto createPatientCard(PatientCardNoIdDto patientCardNoIdDto);
}
