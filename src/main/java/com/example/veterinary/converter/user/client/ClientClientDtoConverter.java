package com.example.veterinary.converter.user.client;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientClientDtoConverter implements Converter<Client, ClientDto> {
    @Override
    public ClientDto convert(Client source) {
        return new ClientDto(source.getId(), source.getName(), source.getSurname());
    }
}
