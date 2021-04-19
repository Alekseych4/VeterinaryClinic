package com.example.veterinary.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class StaffDto extends StaffNoIdDto {
    private UUID id;

    public StaffDto(UUID id, UserType userType, String name, String surname, String position, String experience) {
        super(userType, name, surname, position, experience);
        this.id = id;
    }
}
