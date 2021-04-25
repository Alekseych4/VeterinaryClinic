package com.example.veterinary.service;

import com.example.veterinary.domain.dto.schedule.ScheduleDto;

import java.util.List;
import java.util.UUID;

public interface SpecialistsScheduleService {
    List<ScheduleDto> getAllSchedule();

    ScheduleDto createScheduleItem(ScheduleDto scheduleDto);

    ScheduleDto updateScheduleItem(ScheduleDto scheduleDto);

    void deleteScheduleItem(UUID id);
}
