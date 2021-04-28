package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.StaffDto;

import java.util.UUID;

public interface StaffService {
    StaffDto create(StaffDto staffDto);

    StaffDto update(StaffDto staffDto);

    StaffDto findById(UUID id);

    StaffDto findByName(String name);

    void delete(UUID id);
}
