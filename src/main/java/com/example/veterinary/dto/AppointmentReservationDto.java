package com.example.veterinary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentReservationDto {
    String id;
    String appointmentId;
    String userId;
}
