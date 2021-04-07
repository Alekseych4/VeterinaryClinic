package com.example.veterinary.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto extends AppointmentNoIdDto{
    private String id;
    private String timeStart;
    private String medicalStaffId;
    private String description;

    public AppointmentDto(String id, String timeStart, String medicalStaffId, String description) {
        super(timeStart, medicalStaffId, description);
        this.id = id;
    }
}
