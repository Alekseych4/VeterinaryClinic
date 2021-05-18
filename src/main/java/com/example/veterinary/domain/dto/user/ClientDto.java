package com.example.veterinary.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class ClientDto {
    private UUID id;
    private String name;
    private String surname;

    public ClientDto(UUID id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
