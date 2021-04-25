package com.example.veterinary.converter.patient.card;

import com.example.veterinary.domain.dto.patient.PatientCardNoIdDto;
import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientCardNoIdDtoPatientCardConverter implements Converter<PatientCardNoIdDto, PatientCard> {
    @Override
    public PatientCard convert(PatientCardNoIdDto source) {
        return new PatientCard(source.getClientId(), source.getAge(), source.getName(), source.getWeight(),
                source.getAnimalType());
    }
}
