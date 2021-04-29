package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.service.ScheduleItemService;
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

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/schedules")
public class ScheduleItemController {
    private final ScheduleItemService scheduleItemService;

    @GetMapping
    public List<ScheduleItemDto> getAll(){
        return scheduleItemService.getAll();
    }

    @PostMapping
    public ScheduleItemDto create(@RequestBody ScheduleItemDto scheduleItemDto){
        return scheduleItemService.create(scheduleItemDto);
    }

    @PutMapping
    public ScheduleItemDto update(@RequestBody ScheduleItemDto scheduleItemDto){
        return scheduleItemService.update(scheduleItemDto);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") UUID id){
        scheduleItemService.delete(id);
    }
}
