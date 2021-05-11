package com.example.veterinary.converter.user.client;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoClientConverter implements Converter<ClientDto, Client> {
    @Override
    public Client convert(ClientDto source) {
        return new Client(source.getId(), source.getName(), source.getSurname());
    }
}
