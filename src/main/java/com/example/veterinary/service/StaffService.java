package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.StaffDto;

import java.util.List;
import java.util.UUID;

public interface StaffService {
    StaffDto create(StaffDto staffDto);

    StaffDto update(StaffDto staffDto);

    StaffDto findById(UUID id);

    List<StaffDto> findByNameAndSurname(String fullName, String surname);

    void delete(UUID id);
}
