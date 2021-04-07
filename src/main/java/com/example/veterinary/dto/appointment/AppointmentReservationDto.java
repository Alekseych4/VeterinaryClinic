package com.example.veterinary.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentReservationDto {
    private String id;
    private String appointmentId;
    private String userId;
}
