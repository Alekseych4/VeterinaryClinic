package com.example.veterinary.domain.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentNoIdDto {
    private String timeStart;
    private String medicalStaffId;
    private String description;
}
