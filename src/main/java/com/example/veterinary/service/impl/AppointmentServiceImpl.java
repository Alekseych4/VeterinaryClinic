package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.entity.Appointment;
import com.example.veterinary.repository.AppointmentRepository;
import com.example.veterinary.repository.PatientCardRepository;
import com.example.veterinary.repository.ScheduleItemRepository;
import com.example.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AppointmentServiceImpl implements AppointmentService {
    private final ConversionService conversionService;
    private final AppointmentRepository appointmentRepository;
    private final ScheduleItemRepository scheduleItemRepository;
    private final PatientCardRepository patientCardRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AppointmentDto> getAll() {
        return appointmentRepository.findAll()
                .stream()
                .map(item -> conversionService.convert(item, AppointmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto create(AppointmentDto appointmentDto) {
        var scheduleItem = scheduleItemRepository.getOne(appointmentDto.getScheduleItemId());
        var patientCard = patientCardRepository.getOne(appointmentDto.getPatientCardId());

        Appointment appointment = conversionService.convert(appointmentDto, Appointment.class);
        appointment.setScheduleItem(scheduleItem);
        appointment.setPatientCard(patientCard);

        Appointment result = appointmentRepository.save(appointment);
        return conversionService.convert(result, AppointmentDto.class);
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        var scheduleItem = scheduleItemRepository.getOne(appointmentDto.getScheduleItemId());
        var patientCard = patientCardRepository.getOne(appointmentDto.getPatientCardId());

        Appointment appointment = conversionService.convert(appointmentDto, Appointment.class);
        appointment.setScheduleItem(scheduleItem);
        appointment.setPatientCard(patientCard);
        Appointment result = appointmentRepository.save(appointment);

        return conversionService.convert(result, AppointmentDto.class);
    }

    @Override
    public void delete(UUID id) {
        appointmentRepository.deleteById(id);
    }
}
