package com.example.veterinary.converter.user;

import com.example.veterinary.domain.dto.user.ClientDto;
import com.example.veterinary.domain.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoClientConverter implements Converter<ClientDto, Client> {
    @Override
    public Client convert(ClientDto source) {
        return Client.builder()
                .id(source.getId())
                .name(source.getName())
                .surname(source.getSurname())
                .userType(source.getUserType())
                .build();
    }
}
