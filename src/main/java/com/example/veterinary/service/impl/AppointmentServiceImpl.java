package com.example.veterinary.service.impl;

import com.example.veterinary.dto.appointment.AppointmentDto;
import com.example.veterinary.dto.appointment.AppointmentNoIdDto;
import com.example.veterinary.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<AppointmentDto> getAll() {
        return Arrays.asList(new AppointmentDto("1", "12:00", "23rg3", "descr"));
    }

    @Override
    public AppointmentDto create(AppointmentNoIdDto appointmentNoIdDto) {
        return new AppointmentDto("testId", appointmentNoIdDto.getTimeStart(),
                appointmentNoIdDto.getMedicalStaffId(), appointmentNoIdDto.getDescription());
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        return appointmentDto;
    }

    @Override
    public void delete(String id) {

    }
}
