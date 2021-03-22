package com.example.veterinary.service;

import com.example.veterinary.dto.SpecialistsScheduleDto;
import com.example.veterinary.dto.SpecialistsScheduleNoIdDto;

import java.util.List;

public interface SpecialistsScheduleService {
    List<SpecialistsScheduleDto> getAllSchedule();

    SpecialistsScheduleDto createScheduleItem(SpecialistsScheduleNoIdDto scheduleNoIdDto);

    SpecialistsScheduleDto updateScheduleItem(SpecialistsScheduleDto specialistsScheduleDto);

    void deleteScheduleItem(String id);
}
