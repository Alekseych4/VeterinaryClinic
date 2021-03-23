package com.example.veterinary.controller;

import com.example.veterinary.dto.AppointmentDto;
import com.example.veterinary.dto.AppointmentNoIdDto;
import com.example.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

    @PostMapping("/edit")
    public AppointmentDto create(@RequestBody AppointmentNoIdDto appointmentNoIdDto){
        return appointmentService.create(appointmentNoIdDto);
    }

    @PutMapping("/edit")
    public AppointmentDto update(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping("/edit")
    public void delete(@RequestParam("id") String id){
        appointmentService.delete(id);
    }
}
