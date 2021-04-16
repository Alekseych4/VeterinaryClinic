package com.example.veterinary.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClinicStaffDto extends ClinicStaffNoIdDto {
    private String id;

    public ClinicStaffDto(String id, UserType userType, String name, String surname, String position, String experience) {
        super(userType, name, surname, position, experience);
        this.id = id;
    }
}
