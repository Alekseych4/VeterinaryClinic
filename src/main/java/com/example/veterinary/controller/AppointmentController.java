package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
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

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST')")
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/by-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST')")
    public List<AppointmentDto> getAllByUserId(@RequestParam("id") UUID userId){
        return appointmentService.getAllByCardId(userId);
    }

    @GetMapping("/doctor")
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'RECEPTIONIST')")
    public List<AppointmentDto> getAllByDoctorId(@RequestParam("id") UUID doctorId){
        return appointmentService.getAllByDoctorId(doctorId);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST')")
    public AppointmentDto create(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.create(appointmentDto);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST')")
    public AppointmentDto update(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.update(appointmentDto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST')")
    public void delete(@RequestParam("id") UUID id){
        appointmentService.delete(id);
    }
}
