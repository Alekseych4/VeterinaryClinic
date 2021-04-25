package com.example.veterinary.converter.info;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.domain.entity.InfoAboutClinic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InfoAboutClinicDtoInfoAboutClinicConverter implements Converter<InfoAboutClinicDto, InfoAboutClinic> {
    @Override
    public InfoAboutClinic convert(InfoAboutClinicDto source) {
        InfoAboutClinic infoAboutClinic = new InfoAboutClinic(source.getInfo(), new Date(source.getPublicationDate()));
        infoAboutClinic.setId(source.getId());
        return infoAboutClinic;
    }
}
