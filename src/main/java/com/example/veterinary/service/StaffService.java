package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.StaffNoIdDto;

import java.util.UUID;

public interface StaffService {
    StaffDto create(StaffNoIdDto staffNoIdDto);

    StaffDto update(StaffDto staffDto);

    StaffDto findById(UUID id);

    StaffDto findByName(String name);

    void delete(UUID id);
}
