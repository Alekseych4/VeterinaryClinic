package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;

import java.util.UUID;

public interface PatientCardService {
    PatientCardDto findById(UUID id);

    PatientCardDto create(PatientCardNoIdDto patientCardNoIdDto);

    PatientCardDto update(PatientCardDto patientCardDto);

    void delete(UUID id);
}
