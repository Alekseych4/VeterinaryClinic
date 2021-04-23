package com.example.veterinary.service;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.dto.patient.CardRecordNoIdDto;
import com.example.veterinary.domain.entity.CardRecord;

import java.util.UUID;

public interface CardRecordService {
    CardRecordDto create(CardRecordNoIdDto cardRecordNoIdDto);

    CardRecordDto update(CardRecordDto cardRecordDto);

    CardRecordDto findById(UUID id);
}
