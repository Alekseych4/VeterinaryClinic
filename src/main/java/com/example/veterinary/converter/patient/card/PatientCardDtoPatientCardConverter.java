package com.example.veterinary.converter.patient.card;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientCardDtoPatientCardConverter implements Converter<PatientCardDto, PatientCard> {
    @Override
    public PatientCard convert(PatientCardDto source) {
        if (source.getId() == null){
            return PatientCard.builder()
                    .name(source.getName())
                    .age(source.getAge())
                    .animalType(source.getAnimalType())
                    .weight(source.getWeight())
                    .build();
        }

        return new PatientCard(source.getId(), source.getAge(), source.getName(),
                source.getWeight(), source.getAnimalType());
    }
}
