package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.service.InfoAboutClinicService;
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
import java.util.UUID;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/about")
public class InfoAboutClinicController {

    private final InfoAboutClinicService infoService;

    @GetMapping
    public List<InfoAboutClinicDto> getAllInfo(){
        return infoService.getAllInfo();
    }

    @PostMapping
    public void createInfoItem(@RequestBody InfoAboutClinicDto info){
        infoService.createInfoItem(info);
    }

    @PutMapping
    public InfoAboutClinicDto updateInfoItem(@RequestBody InfoAboutClinicDto aboutClinicDto){
        return infoService.updateInfoItem(aboutClinicDto);
    }

    @DeleteMapping
    public void deleteInfoItem(@RequestParam("id") UUID id){
        infoService.deleteInfoItem(id);
    }
}
