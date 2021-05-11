package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.entity.Client;
import com.example.veterinary.domain.entity.User;
import com.example.veterinary.repository.ClientRepository;
import com.example.veterinary.repository.UserRepository;
import com.example.veterinary.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ClientServiceImpl implements ClientService {

    private final ConversionService conversionService;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client = conversionService.convert(clientDto, Client.class);
        Client res = clientRepository.save(client);
        return conversionService.convert(res, ClientDto.class);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        User user = userRepository.findById(clientDto.getId()).orElseThrow();

        Client client = conversionService.convert(clientDto, Client.class);
        client.setUser(user);
        Client result = clientRepository.save(client);
        return conversionService.convert(result, ClientDto.class);
    }

    @Override
    public ClientDto findById(UUID id) {
        Client client = clientRepository.getOne(id);
        return conversionService.convert(client, ClientDto.class);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.deleteById(id);
    }

}
