package com.example.veterinary.service.impl;

import com.example.veterinary.dto.appointment.AppointmentReservationDto;
import com.example.veterinary.service.AppointmentReservationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentReservationServiceImpl implements AppointmentReservationService {
    @Override
    public List<AppointmentReservationDto> getAll() {
        return Arrays.asList(new AppointmentReservationDto("1", "sdv", "adv3"));
    }

    @Override
    public AppointmentReservationDto create(String userId, String appointmentId) {
        return new AppointmentReservationDto("testId", appointmentId, userId);
    }

    @Override
    public AppointmentReservationDto update(AppointmentReservationDto appointmentDto) {
        return appointmentDto;
    }

    @Override
    public void delete(String id) {

    }
}
