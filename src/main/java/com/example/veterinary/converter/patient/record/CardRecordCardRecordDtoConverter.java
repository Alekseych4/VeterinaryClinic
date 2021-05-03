package com.example.veterinary.converter.patient.record;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.entity.CardRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardRecordCardRecordDtoConverter implements Converter<CardRecord, CardRecordDto> {
    @Override
    public CardRecordDto convert(CardRecord source) {
        return new CardRecordDto(source.getId(), source.getPatientCard().getId(), source.getStaff().getId(),
                source.getDate(), source.getDiagnose(), source.getDescription(),
                source.getPrescription());
    }
}
