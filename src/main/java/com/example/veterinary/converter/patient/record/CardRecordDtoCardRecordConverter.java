package com.example.veterinary.converter.patient.record;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.entity.CardRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardRecordDtoCardRecordConverter implements Converter<CardRecordDto, CardRecord> {
    @Override
    public CardRecord convert(CardRecordDto source) {
        if (source.getId() == null){
            return CardRecord.builder()
                    .date(source.getDate())
                    .description(source.getDescription())
                    .diagnose(source.getDiagnose())
                    .prescription(source.getPrescription())
                    .build();
        }

        return new CardRecord(source.getId(), source.getDate(), source.getDiagnose(), source.getDescription(),
                source.getPrescription());
    }
}
