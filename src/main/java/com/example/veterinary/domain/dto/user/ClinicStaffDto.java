package com.example.veterinary.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClinicStaffDto extends ClinicStaffNoIdDto {
    private String id;
    private UserType userType;
    private String name;
    private String surname;
    private String position;
    private String experience;

    public ClinicStaffDto(String id, UserType userType, String name, String surname, String position, String experience) {
        super(userType, name, surname, position, experience);
        this.id = id;
    }
}
