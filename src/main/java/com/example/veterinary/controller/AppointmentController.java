package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.appointment.AppointmentDto;
import com.example.veterinary.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST')")
    public List<AppointmentDto> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/by-card-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'RECEPTIONIST')")
    public List<AppointmentDto> getAllByCardId(@RequestParam("id") UUID cardId){
        return appointmentService.getAllByCardId(cardId);
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
