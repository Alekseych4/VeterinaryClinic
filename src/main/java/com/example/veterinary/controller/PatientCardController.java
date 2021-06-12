package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.service.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/card")
@CrossOrigin
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PatientCardController {
    private final PatientCardService patientCardService;

    @GetMapping("/my-cards")
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST', 'CLIENT', 'DOCTOR')")
    public List<PatientCardDto> getClientCards(@RequestParam("clientId") UUID clientId){
        return patientCardService.getClientCards(clientId);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST', 'CLIENT', 'DOCTOR')")
    public PatientCardDto findById(@RequestParam("id") UUID id){
        return patientCardService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST', 'CLIENT')")
    public PatientCardDto create(@RequestBody PatientCardDto patientCardDto){
        return patientCardService.create(patientCardDto);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'RECEPTIONIST', 'CLIENT', 'DOCTOR')")
    public PatientCardDto update(@RequestBody PatientCardDto patientCardDto){
        return patientCardService.update(patientCardDto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT')")
    public void delete(@RequestParam("id") UUID id){
        patientCardService.delete(id);
    }
}
