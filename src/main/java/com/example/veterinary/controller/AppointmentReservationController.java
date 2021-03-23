package com.example.veterinary.controller;

import com.example.veterinary.dto.AppointmentReservationDto;
import com.example.veterinary.service.AppointmentReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/appointment-reservations")
public class AppointmentReservationController {
    private final AppointmentReservationService reservationService;

    @GetMapping
    public List<AppointmentReservationDto> getAll(){
        return reservationService.getAll();
    }

    @PostMapping
    public AppointmentReservationDto create(@RequestParam("userId") String userId, @RequestParam("appointmentId") String appointmentId){
        return reservationService.create(userId, appointmentId);
    }

    @PutMapping("/edit")
    public AppointmentReservationDto update(@RequestBody AppointmentReservationDto appointmentReservationDto){
        return reservationService.update(appointmentReservationDto);
    }

    @DeleteMapping("/edit")
    public void delete(@RequestParam("id") String id){
        reservationService.delete(id);
    }
}
