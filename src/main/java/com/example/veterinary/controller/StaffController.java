package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/by-id")
    public StaffDto findById(@RequestParam("id") UUID id){
        return staffService.findById(id);
    }

    @GetMapping("/by-name")
    public StaffDto findByName(@RequestParam("name") String name){
        return staffService.findByName(name);
    }

    @PostMapping
    public StaffDto create(@RequestBody StaffDto staffDto){
        return staffService.create(staffDto);
    }

    @PutMapping
    public StaffDto update(@RequestBody StaffDto staffDto){
        return staffService.update(staffDto);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") UUID id){
        staffService.delete(id);
    }
}
