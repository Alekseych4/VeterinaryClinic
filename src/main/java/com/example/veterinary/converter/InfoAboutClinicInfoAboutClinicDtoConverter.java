package com.example.veterinary.converter;

import com.example.veterinary.domain.dto.info.InfoAboutClinicDto;
import com.example.veterinary.domain.entity.InfoAboutClinic;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InfoAboutClinicInfoAboutClinicDtoConverter implements Converter<InfoAboutClinic, InfoAboutClinicDto> {
    @Override
    public InfoAboutClinicDto convert(InfoAboutClinic source) {
        return new InfoAboutClinicDto(source.getId(), source.getInfo());
    }
}
