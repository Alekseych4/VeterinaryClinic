package com.example.veterinary.converter.patient.record;

import com.example.veterinary.domain.dto.patient.CardRecordNoIdDto;
import com.example.veterinary.domain.entity.CardRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CardRecordNoIdDtoCardRecordConverter implements Converter<CardRecordNoIdDto, CardRecord> {
    @Override
    public CardRecord convert(CardRecordNoIdDto source) {
        return CardRecord.builder()
                .appointmentId(source.getAppointmentId())
                .patientCardId(source.getPatientCardId())
                .staffId(source.getStaffId())
                .description(source.getDescription())
                .diagnose(source.getDiagnose())
                .prescription(source.getPrescription())
                .build();
    }
}
