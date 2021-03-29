package com.example.veterinary.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoggedClientNoIdDto {
    private String name;
    private String surname;
}
