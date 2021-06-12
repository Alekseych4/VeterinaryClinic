package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.user.StaffDto;
import com.example.veterinary.domain.dto.user.UserStaffDto;
import com.example.veterinary.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/staff")
@CrossOrigin
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserStaffDto> getAll(){
        return staffService.getAll();
    }

    @GetMapping("/by-id")
    public StaffDto findById(@RequestParam("id") UUID id){
        return staffService.findById(id);
    }

    @GetMapping("/by-name")
    public List<StaffDto> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return staffService.findByNameAndSurname(name, surname);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public StaffDto update(@RequestBody StaffDto staffDto){
        return staffService.update(staffDto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void delete(@RequestParam("id") UUID id){
        staffService.delete(id);
    }
}
