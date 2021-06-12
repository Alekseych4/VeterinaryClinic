package com.example.veterinary.service;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;

import java.util.List;
import java.util.UUID;

public interface ScheduleItemService {
    List<ScheduleItemDto> getAll();

    List<ScheduleItemDto> getAllByStaffId(UUID staffId);

    ScheduleItemDto create(ScheduleItemDto scheduleItemNoIdDto);

    ScheduleItemDto update(ScheduleItemDto scheduleItemDto);

    void delete(UUID id);

    List<ScheduleItemDto> getAllFree();

    List<ScheduleItemDto> getAllBusy();

    List<ScheduleItemDto> getByClientId(UUID clientId);
}
