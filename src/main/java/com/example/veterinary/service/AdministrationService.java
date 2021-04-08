package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.ClinicStaffDto;
import com.example.veterinary.domain.dto.user.ClinicStaffNoIdDto;

public interface AdministrationService {
    ClinicStaffDto createEmployee(ClinicStaffNoIdDto clinicStaffNoIdDto);

    void deleteEmployee(String id);
}
