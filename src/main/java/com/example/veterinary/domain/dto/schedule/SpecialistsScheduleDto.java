package com.example.veterinary.domain.dto.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialistsScheduleDto extends SpecialistsScheduleNoIdDto{
    private String id;

    public SpecialistsScheduleDto(String id, String timeStart, String specialistName, String specialistPosition, String description) {
        super(timeStart, specialistName, specialistPosition, description);
        this.id = id;
    }
}
