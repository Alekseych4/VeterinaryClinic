package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.StaffNoIdDto;
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
    public StaffDto createEmployee(StaffNoIdDto staffNoIdDto){
        return administrationService.createEmployee(staffNoIdDto);
    }

    @DeleteMapping
    public void deleteEmployee(@RequestParam("id") String id){
        administrationService.deleteEmployee(id);
    }
}
