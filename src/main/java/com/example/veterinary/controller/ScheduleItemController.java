package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.schedule.ScheduleItemDto;
import com.example.veterinary.service.ScheduleItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/schedules")
@CrossOrigin
public class ScheduleItemController {
    private final ScheduleItemService scheduleItemService;

    @GetMapping
    public List<ScheduleItemDto> getAll(){
        return scheduleItemService.getAll();
    }

    @GetMapping("/by-doctor")
    public List<ScheduleItemDto> getAllByStaffId(@RequestParam("id") UUID staffId){
        return scheduleItemService.getAllByStaffId(staffId);
    }

    @GetMapping("/by-client-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST', 'DOCTOR')")
    public List<ScheduleItemDto> getByClientId(@RequestParam("id") UUID clientId){
        return scheduleItemService.getByClientId(clientId);
    }

    @GetMapping("/free")
    public List<ScheduleItemDto> getAllFree(){
        return scheduleItemService.getAllFree();
    }

    @GetMapping("/busy")
    public List<ScheduleItemDto> getAllBusy(){
        return scheduleItemService.getAllBusy();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    public ScheduleItemDto create(@RequestBody ScheduleItemDto scheduleItemDto){
        return scheduleItemService.create(scheduleItemDto);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    public ScheduleItemDto update(@RequestBody ScheduleItemDto scheduleItemDto){
        return scheduleItemService.update(scheduleItemDto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    public void delete(@RequestParam("id") UUID id){
        scheduleItemService.delete(id);
    }
}
