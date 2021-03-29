package com.example.veterinary.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentNoIdDto {
    String timeStart;
    String medicalStaffId;
    String description;
}
