package com.example.veterinary.converter.appointment;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.entity.Appointment;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class AppointmentDtoAppointmentConverter implements Converter<AppointmentDto, Appointment> {
    @Override
    public Appointment convert(AppointmentDto source) {
        Appointment appointment = new Appointment(source.getMedicalStaffId(), new Date(source.getTimeStart()),
                source.getDuration(), source.getDescription());
        appointment.setId(source.getId());
        return appointment;
    }
}
