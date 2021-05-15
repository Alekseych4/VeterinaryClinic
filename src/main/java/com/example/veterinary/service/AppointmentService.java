package com.example.veterinary.service;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentDto> getAll();

    AppointmentDto create(AppointmentDto appointmentDto);

    AppointmentDto update(AppointmentDto appointmentDto);

    void delete(UUID id);

    List<AppointmentDto> getAllByCardId(UUID userId);
}
