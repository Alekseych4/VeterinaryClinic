package com.example.veterinary.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class LoggedClientDto {
    private String id;
    private String name;
    private String surname;
}
