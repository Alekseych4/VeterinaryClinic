package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.CardRecordDto;

import java.util.List;
import java.util.UUID;

public interface CardRecordService {
    CardRecordDto create(CardRecordDto cardRecordNoIdDto);

    CardRecordDto update(CardRecordDto cardRecordDto);

    CardRecordDto findById(UUID id);

    List<CardRecordDto> getCardRecords(UUID id);

    List<CardRecordDto> getRecordsByDoctorId(UUID doctorId);
}
