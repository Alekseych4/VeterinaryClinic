package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.service.InfoAboutClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/about")
@CrossOrigin
public class InfoAboutClinicController {

    private final InfoAboutClinicService infoService;

    @GetMapping
    public List<InfoAboutClinicDto> getAllInfo(){
        return infoService.getAllInfo();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void createInfoItem(@RequestBody InfoAboutClinicDto info){
        infoService.createInfoItem(info);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public InfoAboutClinicDto updateInfoItem(@RequestBody InfoAboutClinicDto aboutClinicDto){
        return infoService.updateInfoItem(aboutClinicDto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteInfoItem(@RequestParam("id") UUID id){
        infoService.deleteInfoItem(id);
    }
}
