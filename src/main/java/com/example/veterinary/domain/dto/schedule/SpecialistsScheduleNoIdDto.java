package com.example.veterinary.domain.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SpecialistsScheduleNoIdDto {
    private String timeStart;
    private String specialistName;
    private String specialistPosition;
    private String description;
}
