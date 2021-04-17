package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.dto.user.ClientNoIdDto;

public interface ClientSignUpService {
    ClientDto createUser(ClientNoIdDto clientDto);

    PatientCardDto createPatientCard(PatientCardNoIdDto patientCardNoIdDto);
}
