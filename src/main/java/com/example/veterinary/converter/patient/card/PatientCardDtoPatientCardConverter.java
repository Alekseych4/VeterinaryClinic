package com.example.veterinary.converter.patient.card;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientCardDtoPatientCardConverter implements Converter<PatientCardDto, PatientCard> {
    @Override
    public PatientCard convert(PatientCardDto source) {
        return new PatientCard(source.getClientId(), source.getAge(), source.getName(), source.getWeight(),
                source.getAnimalType());
    }
}
