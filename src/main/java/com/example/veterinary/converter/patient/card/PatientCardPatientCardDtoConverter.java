package com.example.veterinary.converter.patient.card;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientCardPatientCardDtoConverter implements Converter<PatientCard, PatientCardDto> {
    @Override
    public PatientCardDto convert(PatientCard source) {
        return new PatientCardDto(source.getId(), source.getClient().getId(), source.getAge(), source.getName(), source.getWeight(),
                source.getAnimalType());
    }
}
