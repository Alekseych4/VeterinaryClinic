package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.domain.entity.CardRecord;
import com.example.veterinary.service.CardRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CardRecordController {
    private final CardRecordService cardRecordService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'MEDICAL_STAFF', 'CLIENT')")
    public CardRecordDto findById(@RequestParam("id") UUID id){
        return cardRecordService.findById(id);
    }

    @GetMapping("/by-card-id")
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'MEDICAL_STAFF', 'CLIENT')")
    public List<CardRecordDto> getCardRecords(@RequestParam("id") UUID id){
        return cardRecordService.getCardRecords(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    public CardRecordDto create(@RequestBody CardRecordDto cardRecordDto){
        return cardRecordService.create(cardRecordDto);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR')")
    public CardRecordDto update(@RequestBody CardRecordDto cardRecordDto){
        return cardRecordService.update(cardRecordDto);
    }

}
