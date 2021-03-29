package com.example.veterinary.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoggedClientDto extends LoggedClientNoIdDto {

    private String id;

    public LoggedClientDto(String id, String name, String surname) {
        super(name, surname);
        this.id = id;
    }
}
