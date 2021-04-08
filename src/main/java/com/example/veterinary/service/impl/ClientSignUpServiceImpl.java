package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.domain.dto.user.LoggedClientDto;
import com.example.veterinary.domain.dto.user.LoggedClientNoIdDto;
import com.example.veterinary.service.ClientSignUpService;
import org.springframework.stereotype.Service;

@Service
public class ClientSignUpServiceImpl implements ClientSignUpService {

    @Override
    public LoggedClientDto createUser(LoggedClientNoIdDto clientDto) {
        return new LoggedClientDto(generateId(), clientDto.getName(), clientDto.getSurname());
    }

    @Override
    public PatientCardDto createPatientCard(PatientCardNoIdDto patientCardNoIdDto) {
        return new PatientCardDto(generateId(), patientCardNoIdDto.getClientId(), patientCardNoIdDto.getAge(),
                patientCardNoIdDto.getName(), patientCardNoIdDto.getWeight(), patientCardNoIdDto.getAnimalType());
    }

    private String generateId(){
        return "testId";
    }
}
