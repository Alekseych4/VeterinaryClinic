package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.StaffNoIdDto;
import com.example.veterinary.service.AdministrationService;
import org.springframework.stereotype.Service;

@Service
public class AdministrationServiceImpl implements AdministrationService {
    @Override
    public StaffDto createEmployee(StaffNoIdDto staffNoIdDto) {
        return new StaffDto(generateId(), staffNoIdDto.getUserType(), staffNoIdDto.getName(),
                staffNoIdDto.getSurname(), staffNoIdDto.getPosition(), staffNoIdDto.getExperience());
    }

    @Override
    public void deleteEmployee(String id) {

    }

    private String generateId(){
        return "testId";
    }
}
