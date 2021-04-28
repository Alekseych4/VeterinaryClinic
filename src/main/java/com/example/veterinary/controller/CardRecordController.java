package com.example.veterinary.controller;

import com.example.veterinary.domain.dto.patient.CardRecordDto;
import com.example.veterinary.service.CardRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CardRecordController {
    private final CardRecordService cardRecordService;

    @GetMapping
    public CardRecordDto findById(@RequestParam("id") UUID id){
        return cardRecordService.findById(id);
    }

    @PostMapping
    public CardRecordDto create(@RequestBody CardRecordDto cardRecordDto){
        return cardRecordService.create(cardRecordDto);
    }

    @PutMapping
    public CardRecordDto update(@RequestBody CardRecordDto cardRecordDto){
        return cardRecordService.update(cardRecordDto);
    }

}
