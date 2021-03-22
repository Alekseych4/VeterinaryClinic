package com.example.veterinary.service.impl;

import com.example.veterinary.dto.SpecialistsScheduleDto;
import com.example.veterinary.dto.SpecialistsScheduleNoIdDto;
import com.example.veterinary.service.SpecialistsScheduleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpecialistsScheduleServiceImpl implements SpecialistsScheduleService {
    @Override
    public List<SpecialistsScheduleDto> getAllSchedule() {
        return Arrays.asList(SpecialistsScheduleDto.builder()
                .id(generateId())
                .specialistName("name")
                .specialistPosition("doctor")
                .timeStart("10:00")
                .description("Treat animals")
                .build());
    }

    @Override
    public SpecialistsScheduleDto createScheduleItem(SpecialistsScheduleNoIdDto scheduleNoIdDto) {
        return SpecialistsScheduleDto.builder()
                .id(generateId())
                .specialistName(scheduleNoIdDto.getSpecialistName())
                .specialistPosition(scheduleNoIdDto.getSpecialistPosition())
                .timeStart(scheduleNoIdDto.getTimeStart())
                .description(scheduleNoIdDto.getDescription())
                .build();
    }

    @Override
    public SpecialistsScheduleDto updateScheduleItem(SpecialistsScheduleDto specialistsScheduleDto) {
        return specialistsScheduleDto;
    }

    @Override
    public void deleteScheduleItem(String id) {

    }

    private String generateId(){
        return "testId";
    }
}
