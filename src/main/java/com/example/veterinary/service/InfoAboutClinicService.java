package com.example.veterinary.service;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;

import java.util.List;

public interface InfoAboutClinicService {
    /**
     *
     * @param userType this param is just a reminder to make access to certain operations dependent on type of user
     * @return
     */
    List<InfoAboutClinicDto> getAllInfo(String userType);

    void createInfoItem(String info);

    InfoAboutClinicDto updateInfoItem(InfoAboutClinicDto infoAboutClinicDto);

    void deleteInfoItem(String id);
}
