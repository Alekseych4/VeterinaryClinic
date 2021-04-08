package com.example.veterinary.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ClinicStaffNoIdDto {
    private UserType userType;
    private String name;
    private String surname;
    private String position;
    private String experience;
}
