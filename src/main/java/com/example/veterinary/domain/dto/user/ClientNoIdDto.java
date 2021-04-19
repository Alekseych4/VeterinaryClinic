package com.example.veterinary.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ClientNoIdDto {
    private String name;
    private String surname;
    private UserType userType = UserType.CLIENT;

    public ClientNoIdDto(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
}
