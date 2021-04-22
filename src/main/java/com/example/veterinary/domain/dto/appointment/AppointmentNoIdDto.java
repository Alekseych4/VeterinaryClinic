package com.example.veterinary.domain.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentNoIdDto {
    private long timeStart;
    private long duration;
    private UUID medicalStaffId;
    private String description;
}
