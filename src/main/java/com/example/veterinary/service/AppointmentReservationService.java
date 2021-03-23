package com.example.veterinary.service;

import com.example.veterinary.dto.AppointmentReservationDto;

import java.util.List;

public interface AppointmentReservationService {
    List<AppointmentReservationDto> getAll();

    AppointmentReservationDto create(String userId, String appointmentId);

    AppointmentReservationDto update(AppointmentReservationDto appointmentDto);

    void delete(String id);
}
