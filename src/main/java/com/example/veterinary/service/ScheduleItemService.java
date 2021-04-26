package com.example.veterinary.service;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;

import java.util.List;
import java.util.UUID;

public interface ScheduleItemService {
    List<ScheduleItemDto> getAll();

    ScheduleItemDto create(ScheduleItemDto scheduleItemNoIdDto);

    ScheduleItemDto update(ScheduleItemDto scheduleItemDto);

    void delete(UUID id);
}
