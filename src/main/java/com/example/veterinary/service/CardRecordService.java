package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.CardRecordDto;

import java.util.UUID;

public interface CardRecordService {
    CardRecordDto create(CardRecordDto cardRecordNoIdDto);

    CardRecordDto update(CardRecordDto cardRecordDto);

    CardRecordDto findById(UUID id);
}
