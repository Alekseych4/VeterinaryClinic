package com.example.veterinary.service.impl;

import com.example.veterinary.dto.user.ClinicStaffDto;
import com.example.veterinary.dto.user.ClinicStaffNoIdDto;
import com.example.veterinary.service.AdministrationService;
import org.springframework.stereotype.Service;

@Service
public class AdministrationServiceImpl implements AdministrationService {
    @Override
    public ClinicStaffDto createEmployee(ClinicStaffNoIdDto clinicStaffNoIdDto) {
        return new ClinicStaffDto(generateId(), clinicStaffNoIdDto.getUserType(), clinicStaffNoIdDto.getName(),
                clinicStaffNoIdDto.getSurname(), clinicStaffNoIdDto.getPosition(), clinicStaffNoIdDto.getExperience());
    }

    @Override
    public void deleteEmployee(String id) {

    }

    private String generateId(){
        return "testId";
    }
}
