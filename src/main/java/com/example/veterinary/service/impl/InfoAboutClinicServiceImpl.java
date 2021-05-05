package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.domain.entity.InfoAboutClinic;
import com.example.veterinary.repository.InfoAboutClinicRepository;
import com.example.veterinary.service.InfoAboutClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InfoAboutClinicServiceImpl implements InfoAboutClinicService {

    private final InfoAboutClinicRepository infoAboutClinicRepository;
    private final ConversionService conversionService;

    @Transactional(readOnly = true)
    @Override
    public List<InfoAboutClinicDto> getAllInfo() {
        return infoAboutClinicRepository.findAll()
                .stream()
                .map(item -> conversionService.convert(item, InfoAboutClinicDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createInfoItem(InfoAboutClinicDto infoNoIdDto) {
        InfoAboutClinic infoAboutClinic = conversionService.convert(infoNoIdDto, InfoAboutClinic.class);
        infoAboutClinicRepository.save(infoAboutClinic);
    }

    @Transactional
    @Override
    public InfoAboutClinicDto updateInfoItem(InfoAboutClinicDto infoAboutClinicDto) {
        InfoAboutClinic infoAboutClinic = conversionService.convert(infoAboutClinicDto, InfoAboutClinic.class);
        InfoAboutClinic result = infoAboutClinicRepository.save(infoAboutClinic);
        return conversionService.convert(result, InfoAboutClinicDto.class);
    }

    @Override
    public void deleteInfoItem(UUID id) {
        infoAboutClinicRepository.deleteById(id);
    }
}
