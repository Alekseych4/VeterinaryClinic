package com.example.veterinary.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ClientDto extends ClientNoIdDto {

    private UUID id;

    public ClientDto(UUID id, String name, String surname) {
        super(name, surname);
        this.id = id;
    }
}
