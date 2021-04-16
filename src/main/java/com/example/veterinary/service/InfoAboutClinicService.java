package com.example.veterinary.service;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.domain.dto.info.InfoAboutClinicNoIdDto;

import java.util.List;
import java.util.UUID;

public interface InfoAboutClinicService {

    List<InfoAboutClinicDto> getAllInfo();

    void createInfoItem(InfoAboutClinicNoIdDto info);

    InfoAboutClinicDto updateInfoItem(InfoAboutClinicDto infoAboutClinicDto);

    void deleteInfoItem(UUID id);
}
