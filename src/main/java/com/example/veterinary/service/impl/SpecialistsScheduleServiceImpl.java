package com.example.veterinary.service.impl;

import com.example.veterinary.dto.schedule.SpecialistsScheduleDto;
import com.example.veterinary.dto.schedule.SpecialistsScheduleNoIdDto;
import com.example.veterinary.service.SpecialistsScheduleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpecialistsScheduleServiceImpl implements SpecialistsScheduleService {
    @Override
    public List<SpecialistsScheduleDto> getAllSchedule() {
        return Arrays.asList(new SpecialistsScheduleDto("5", "10:00", "name",
                "doctor", "Treat animals"));
    }

    @Override
    public SpecialistsScheduleDto createScheduleItem(SpecialistsScheduleNoIdDto scheduleNoIdDto) {
        return new SpecialistsScheduleDto(generateId(), scheduleNoIdDto.getTimeStart(), scheduleNoIdDto.getSpecialistName(),
                scheduleNoIdDto.getSpecialistPosition(), scheduleNoIdDto.getDescription());
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
