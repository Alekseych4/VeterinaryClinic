package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.StaffNoIdDto;

public interface AdministrationService {
    StaffDto createEmployee(StaffNoIdDto staffNoIdDto);

    void deleteEmployee(String id);
}
