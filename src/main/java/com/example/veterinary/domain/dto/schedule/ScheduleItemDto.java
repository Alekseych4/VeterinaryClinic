package com.example.veterinary.domain.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleItemDto {
    private UUID id;
    private long timeStart;
    private long duration;
    private UUID medicalStaffId;
    private String description;

    public ScheduleItemDto(long timeStart, long duration, UUID medicalStaffId, String description) {
        this.timeStart = timeStart;
        this.duration = duration;
        this.medicalStaffId = medicalStaffId;
        this.description = description;
    }
}
