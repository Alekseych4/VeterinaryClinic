package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.PatientCardDto;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface PatientCardService {
    PatientCardDto findById(UUID id);

    PatientCardDto create(PatientCardDto patientCardDto);

    PatientCardDto update(PatientCardDto patientCardDto);

    void delete(UUID id);

    List<PatientCardDto> getClientCards(UUID clientId);
}
