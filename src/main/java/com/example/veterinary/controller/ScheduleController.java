package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.schedule.ScheduleDto;
import com.example.veterinary.service.SpecialistsScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final SpecialistsScheduleService scheduleService;

    @GetMapping
    public List<ScheduleDto> getAllSchedule(){
        return scheduleService.getAllSchedule();
    }

    @PostMapping
    public ScheduleDto createScheduleItem(@RequestBody ScheduleDto scheduleDto){
        return scheduleService.createScheduleItem(scheduleDto);
    }

    @PutMapping
    public ScheduleDto updateScheduleItem(@RequestBody ScheduleDto scheduleDto){
        return scheduleService.updateScheduleItem(scheduleDto);
    }

    @DeleteMapping
    public void deleteScheduleItem(@RequestParam("id") UUID id){
        scheduleService.deleteScheduleItem(id);
    }
}
