package com.example.veterinary.controller;

import com.example.veterinary.dto.user.ClinicStaffDto;
import com.example.veterinary.dto.user.ClinicStaffNoIdDto;
import com.example.veterinary.service.AdministrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdministrationController {

    private final AdministrationService administrationService;

    @PostMapping
    public ClinicStaffDto createEmployee(ClinicStaffNoIdDto clinicStaffNoIdDto){
        return administrationService.createEmployee(clinicStaffNoIdDto);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestParam("id") String id){
        administrationService.deleteEmployee(id);
    }
}
