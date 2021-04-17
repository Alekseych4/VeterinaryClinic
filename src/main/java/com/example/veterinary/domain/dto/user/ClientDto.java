package com.example.veterinary.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto extends ClientNoIdDto {

    private String id;

    public ClientDto(String id, String name, String surname) {
        super(name, surname);
        this.id = id;
    }
}
