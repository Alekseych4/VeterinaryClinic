package com.example.veterinary.controller;

import com.example.veterinary.dto.SpecialistsScheduleDto;
import com.example.veterinary.dto.SpecialistsScheduleNoIdDto;
import com.example.veterinary.service.SpecialistsScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/edit")
    public SpecialistsScheduleDto createScheduleItem(@RequestBody SpecialistsScheduleNoIdDto scheduleNoIdDto){
        return scheduleService.createScheduleItem(scheduleNoIdDto);
    }

    @PutMapping("/edit")
    public SpecialistsScheduleDto updateScheduleItem(@RequestBody SpecialistsScheduleDto specialistsScheduleDto){
        return scheduleService.updateScheduleItem(specialistsScheduleDto);
    }

    @DeleteMapping("/edit")
    public void deleteScheduleItem(@RequestParam("id") String id){
        scheduleService.deleteScheduleItem(id);
    }
}
