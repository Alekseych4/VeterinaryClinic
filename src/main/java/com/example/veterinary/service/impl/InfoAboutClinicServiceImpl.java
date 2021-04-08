package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.service.InfoAboutClinicService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InfoAboutClinicServiceImpl implements InfoAboutClinicService {
    @Override
    public List<InfoAboutClinicDto> getAllInfo(String userType) {
        return Arrays.asList(InfoAboutClinicDto.builder().id("5").info("Test").build(),
                InfoAboutClinicDto.builder().id("9").info("Test info 2").build());
    }

    @Override
    public void createInfoItem(String info) {
        System.out.println(InfoAboutClinicDto.builder().id(generateId()).info(info).build().toString());
    }

    @Override
    public InfoAboutClinicDto updateInfoItem(InfoAboutClinicDto infoAboutClinicDto) {
        return infoAboutClinicDto;
    }

    @Override
    public void deleteInfoItem(String id) {

    }

    private String generateId(){
        return "testId";
    }
}
