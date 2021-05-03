package com.example.veterinary.converter.appointment;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.entity.Appointment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoAppointmentConverter implements Converter<AppointmentDto, Appointment> {

    @Override
    public Appointment convert(AppointmentDto source) {
        if (source.getId() == null){
            return Appointment.builder().build();
        }

        return new Appointment(source.getId());
    }
}
