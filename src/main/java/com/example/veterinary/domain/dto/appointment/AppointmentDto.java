package com.example.veterinary.domain.dto.appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto extends AppointmentNoIdDto{
    private String id;

    public AppointmentDto(String id, String timeStart, String medicalStaffId, String description) {
        super(timeStart, medicalStaffId, description);
        this.id = id;
    }
}
