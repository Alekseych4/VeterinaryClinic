package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.entity.Appointment;
import com.example.veterinary.domain.entity.ScheduleItem;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.exception.controller.NoSuchRecordException;
import com.example.veterinary.repository.AppointmentRepository;
import com.example.veterinary.repository.PatientCardRepository;
import com.example.veterinary.repository.ScheduleItemRepository;
import com.example.veterinary.repository.StaffRepository;
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
    private final StaffRepository staffRepository;

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
        var scheduleItem = scheduleItemRepository.findById(appointmentDto.getScheduleItemId())
                .orElseThrow(NoSuchRecordException::new);
        var patientCard = patientCardRepository.findById(appointmentDto.getPatientCardId())
                .orElseThrow(NoSuchRecordException::new);

        Appointment appointment = conversionService.convert(appointmentDto, Appointment.class);
        appointment.setScheduleItem(scheduleItem);
        appointment.setPatientCard(patientCard);

        Appointment result = appointmentRepository.save(appointment);
        return conversionService.convert(result, AppointmentDto.class);
    }

    @Override
    public AppointmentDto update(AppointmentDto appointmentDto) {
        var scheduleItem = scheduleItemRepository.findById(appointmentDto.getScheduleItemId())
                .orElseThrow(NoSuchRecordException::new);
        var patientCard = patientCardRepository.findById(appointmentDto.getPatientCardId())
                .orElseThrow(NoSuchRecordException::new);

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

    @Override
    public List<AppointmentDto> getAllByCardId(UUID cardId) {
        return appointmentRepository
                .findAllByPatientCard(patientCardRepository.findById(cardId)
                        .orElseThrow())
                .stream()
                .map(item -> conversionService.convert(item, AppointmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAllByDoctorId(UUID doctorId) {
        Staff staff = staffRepository.findById(doctorId).orElseThrow(NoSuchRecordException::new);

        return staff.getSchedule().stream()
                .filter(scheduleItem -> scheduleItem.getAppointment() != null)
                .map(scheduleItem -> scheduleItem.getAppointment())
                .map(appointment -> conversionService.convert(appointment, AppointmentDto.class))
                .collect(Collectors.toList());


    }
}
