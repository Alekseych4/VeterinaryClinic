package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.patient.PatientCardDto;
import com.example.veterinary.domain.entity.Client;
import com.example.veterinary.domain.entity.PatientCard;
import com.example.veterinary.exception.controller.NoSuchRecordException;
import com.example.veterinary.repository.ClientRepository;
import com.example.veterinary.repository.PatientCardRepository;
import com.example.veterinary.service.PatientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PatientCardServiceImpl implements PatientCardService {
    private final ConversionService conversionService;
    private final PatientCardRepository patientCardRepository;
    private final ClientRepository clientRepository;

    @Override
    public PatientCardDto findById(UUID id) {
        PatientCard patientCard = patientCardRepository.findById(id)
                .orElseThrow(NoSuchRecordException::new);
        return conversionService.convert(patientCard, PatientCardDto.class);
    }

    @Override
    public PatientCardDto create(PatientCardDto patientCardDto) {
        Client client = clientRepository.findById(patientCardDto.getClientId())
                .orElseThrow(NoSuchRecordException::new);

        PatientCard patientCard = conversionService.convert(patientCardDto, PatientCard.class);
        patientCard.setClient(client);
        PatientCard result = patientCardRepository.save(patientCard);

        return conversionService.convert(result, PatientCardDto.class);
    }

    @Override
    public PatientCardDto update(PatientCardDto patientCardDto) {
        Client client = clientRepository.findById(patientCardDto.getClientId())
                .orElseThrow(NoSuchRecordException::new);

        PatientCard patientCard = conversionService.convert(patientCardDto, PatientCard.class);
        patientCard.setClient(client);
        PatientCard result = patientCardRepository.save(patientCard);

        return conversionService.convert(result, PatientCardDto.class);
    }

    @Override
    public void delete(UUID id) {
        patientCardRepository.deleteById(id);
    }

    @Override
    public List<PatientCardDto> getClientCards(UUID clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(NoSuchRecordException::new);

        return client.getPatientCards().stream()
                .map(item -> conversionService.convert(item, PatientCardDto.class))
                .collect(Collectors.toList());
    }
}
