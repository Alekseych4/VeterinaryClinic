package com.example.veterinary.converter.info;

import com.example.veterinary.domain.dto.info.InfoAboutClinicNoIdDto;
import com.example.veterinary.domain.entity.InfoAboutClinic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class InfoAboutClinicNoIdDtoInfoAboutClinicConverter implements Converter<InfoAboutClinicNoIdDto, InfoAboutClinic> {
    @Override
    public InfoAboutClinic convert(InfoAboutClinicNoIdDto source) {
        return new InfoAboutClinic(source.getInfo(), new Date(source.getPublicationDate()));
    }
}
