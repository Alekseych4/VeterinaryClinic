package com.example.veterinary.service;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.dto.user.ClientNoIdDto;

import java.util.UUID;

public interface ClientService {
    ClientDto create(ClientNoIdDto clientDto);

    ClientDto update(ClientDto clientDto);

    ClientDto findById(UUID id);

    void delete(UUID id);
}
