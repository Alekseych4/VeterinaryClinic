package com.example.veterinary.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoggedClientNoIdDto {
    private String name;
    private String surname;
}
