package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.service.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PatientCardController {
    private final PatientCardService patientCardService;

    @GetMapping
    public PatientCardDto findById(@RequestParam("id") UUID id){
        return patientCardService.findById(id);
    }

    @PostMapping
    public PatientCardDto create(@RequestBody PatientCardDto patientCardDto){
        return patientCardService.create(patientCardDto);
    }

    @PutMapping
    public PatientCardDto update(@RequestBody PatientCardDto patientCardDto){
        return patientCardService.update(patientCardDto);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") UUID id){
        patientCardService.delete(id);
    }
}
