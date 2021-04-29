package com.example.veterinary.domain.dto.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleItemDto {
    private UUID id;
    private Date timeStart;
    private long duration;
    private UUID medicalStaffId;
    private String description;
}
