package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.dto.patient.CardRecordNoIdDto;
import com.example.veterinary.domain.entity.CardRecord;
import com.example.veterinary.repository.CardRecordRepository;
import com.example.veterinary.service.CardRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CardRecordServiceImpl implements CardRecordService {
    private final ConversionService conversionService;
    private final CardRecordRepository cardRecordRepository;

    @Override
    public CardRecordDto create(CardRecordNoIdDto cardRecordNoIdDto) {
        CardRecord cardRecord = conversionService.convert(cardRecordNoIdDto, CardRecord.class);
        CardRecord result = cardRecordRepository.save(cardRecord);
        return conversionService.convert(result, CardRecordDto.class);
    }

    @Override
    public CardRecordDto update(CardRecordDto cardRecordDto) {
        CardRecord cardRecord = conversionService.convert(cardRecordDto, CardRecord.class);
        CardRecord result = cardRecordRepository.save(cardRecord);
        return conversionService.convert(result, CardRecordDto.class);
    }

    @Override
    public CardRecordDto findById(UUID id) {
        var cardRecord = cardRecordRepository.getOne(id);
        return conversionService.convert(cardRecord, CardRecordDto.class);
    }
}
