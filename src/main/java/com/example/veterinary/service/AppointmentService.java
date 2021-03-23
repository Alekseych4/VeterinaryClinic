package com.example.veterinary.service;

import com.example.veterinary.dto.AppointmentDto;
import com.example.veterinary.dto.AppointmentNoIdDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAll();

    AppointmentDto create(AppointmentNoIdDto appointmentNoIdDto);

    AppointmentDto update(AppointmentDto appointmentDto);

    void delete(String id);
}
