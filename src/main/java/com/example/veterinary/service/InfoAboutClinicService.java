package com.example.veterinary.service;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;

import java.util.List;
import java.util.UUID;

public interface InfoAboutClinicService {

    List<InfoAboutClinicDto> getAllInfo();

    void createInfoItem(InfoAboutClinicDto info);

    InfoAboutClinicDto updateInfoItem(InfoAboutClinicDto infoAboutClinicDto);

    void deleteInfoItem(UUID id);
}
