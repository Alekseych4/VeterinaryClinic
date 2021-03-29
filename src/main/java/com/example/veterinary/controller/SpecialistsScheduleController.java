package com.example.veterinary.controller;

import com.example.veterinary.dto.schedule.SpecialistsScheduleDto;
import com.example.veterinary.dto.schedule.SpecialistsScheduleNoIdDto;
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

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/schedules")
public class SpecialistsScheduleController {

    private final SpecialistsScheduleService scheduleService;

    @GetMapping
    public List<SpecialistsScheduleDto> getAllSchedule(){
        return scheduleService.getAllSchedule();
    }

    @PostMapping
    public SpecialistsScheduleDto createScheduleItem(@RequestBody SpecialistsScheduleNoIdDto scheduleNoIdDto){
        return scheduleService.createScheduleItem(scheduleNoIdDto);
    }

    @PutMapping
    public SpecialistsScheduleDto updateScheduleItem(@RequestBody SpecialistsScheduleDto specialistsScheduleDto){
        return scheduleService.updateScheduleItem(specialistsScheduleDto);
    }

    @DeleteMapping
    public void deleteScheduleItem(@RequestParam("id") String id){
        scheduleService.deleteScheduleItem(id);
    }
}
