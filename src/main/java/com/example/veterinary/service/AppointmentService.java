package com.example.veterinary.service;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.dto.appointment.AppointmentNoIdDto;

import java.util.List;

public interface AppointmentService {
    List<AppointmentDto> getAll();

    AppointmentDto create(AppointmentNoIdDto appointmentNoIdDto);

    AppointmentDto update(AppointmentDto appointmentDto);

    void delete(String id);
}
