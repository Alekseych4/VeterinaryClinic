package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.service.AppointmentService;
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
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

    @PostMapping
    public AppointmentDto create(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.create(appointmentDto);
    }

    @PutMapping
    public AppointmentDto update(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") UUID id){
        appointmentService.delete(id);
    }
}
