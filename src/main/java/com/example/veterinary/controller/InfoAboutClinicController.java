package com.example.veterinary.controller;

import com.example.veterinary.dto.InfoAboutClinicDto;
import com.example.veterinary.service.InfoAboutClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/about")
public class InfoAboutClinicController {

    private final InfoAboutClinicService infoService;

    @GetMapping
    public List<InfoAboutClinicDto> getAllInfo(@RequestParam("userType") String userType){
        return infoService.getAllInfo(userType);
    }

    @PostMapping("/{info}")
    //TODO: Test this before push
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No permission for this data")
    public void createInfoItem(@PathVariable("info") String info){
        infoService.createInfoItem(info);
    }

    @PatchMapping
    public InfoAboutClinicDto updateInfoItem(@RequestBody InfoAboutClinicDto aboutClinicDto){
        return infoService.updateInfoItem(aboutClinicDto);
    }

    @DeleteMapping
    public void deleteAllInfo(@RequestParam("id") String id){
        infoService.deleteInfoItem(id);
    }
}
