package com.example.veterinary.domain.dto.appointment;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AppointmentDto extends AppointmentNoIdDto{
    private UUID id;

    public AppointmentDto(UUID id, long timeStart, long duration, UUID medicalStaffId, String description) {
        super(timeStart, duration, medicalStaffId, description);
        this.id = id;
    }
}
