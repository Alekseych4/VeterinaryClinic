package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.ClientDto;

import java.util.UUID;

public interface ClientService {
    ClientDto create(ClientDto clientDto);

    ClientDto update(ClientDto clientDto);

    ClientDto findById(UUID id);

    void delete(UUID id);
}
