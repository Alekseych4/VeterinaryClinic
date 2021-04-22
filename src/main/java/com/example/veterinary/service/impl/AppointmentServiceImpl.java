package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.dto.appointment.AppointmentNoIdDto;
import com.example.veterinary.domain.entity.Appointment;
import com.example.veterinary.repository.AppointmentRepository;
import com.example.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ConversionService conversionService;

    @Override
    public List<AppointmentDto> getAll() {
        List<AppointmentDto> result = new ArrayList<>();

        appointmentRepository.findAll().forEach(item -> result.add(conversionService.convert(item, AppointmentDto.class)));
        return result;
    }

    @Override
    public AppointmentDto create(AppointmentNoIdDto appointmentNoIdDto) {
        Appointment appointment = conversionService.convert(appointmentNoIdDto, Appointment.class);
        Appointment result = appointmentRepository.save(appointment);
        return conversionService.convert(result, AppointmentDto.class);
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        Appointment appointment = conversionService.convert(appointmentDto, Appointment.class);
        Appointment result = appointmentRepository.save(appointment);
        return conversionService.convert(result, AppointmentDto.class);
    }

    @Override
    public void delete(UUID id) {
        appointmentRepository.deleteById(id);
    }
}
