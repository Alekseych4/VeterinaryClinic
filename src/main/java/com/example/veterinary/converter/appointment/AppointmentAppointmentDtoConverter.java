package com.example.veterinary.converter.appointment;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.domain.entity.Appointment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AppointmentAppointmentDtoConverter implements Converter<Appointment, AppointmentDto> {
    @Override
    public AppointmentDto convert(Appointment source) {
        return new AppointmentDto(source.getId(), source.getTimeStart().getTime(), source.getDuration().getTime(),
                source.getStaffId(), source.getDescription());
    }
}
