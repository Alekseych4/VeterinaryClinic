package com.example.veterinary.converter.user;

import com.example.veterinary.domain.dto.user.ClientNoIdDto;
import com.example.veterinary.domain.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientNoIdDtoClientConverter implements Converter<ClientNoIdDto, Client> {
    @Override
    public Client convert(ClientNoIdDto source) {
        return Client.builder()
                .id(UUID.randomUUID())
                .name(source.getName())
                .surname(source.getSurname())
                .userType(source.getUserType())
                .build();
    }
}
