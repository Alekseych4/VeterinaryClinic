package com.example.veterinary.controller;

import com.example.veterinary.dto.appointment.AppointmentDto;
import com.example.veterinary.dto.appointment.AppointmentNoIdDto;
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

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

    @PostMapping
    public AppointmentDto create(@RequestBody AppointmentNoIdDto appointmentNoIdDto){
        return appointmentService.create(appointmentNoIdDto);
    }

    @PutMapping
    public AppointmentDto update(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") String id){
        appointmentService.delete(id);
    }
}
