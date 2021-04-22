package com.example.veterinary.converter.appointment;

import com.example.veterinary.domain.dto.appointment.AppointmentNoIdDto;
import com.example.veterinary.domain.entity.Appointment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppointmentNoIdDtoAppointmentConverter implements Converter<AppointmentNoIdDto, Appointment> {
    @Override
    public Appointment convert(AppointmentNoIdDto source) {
        return new Appointment(source.getMedicalStaffId(), new Date(source.getTimeStart()), new Date(source.getDuration()),
                source.getDescription());
    }
}
