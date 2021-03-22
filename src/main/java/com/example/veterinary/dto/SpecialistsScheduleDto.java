package com.example.veterinary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class SpecialistsScheduleDto {
    private String id;
    private String timeStart;
    private String specialistName;
    private String specialistPosition;
    private String description;

}
