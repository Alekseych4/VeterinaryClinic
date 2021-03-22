package com.example.veterinary.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class ClinicStaffDto {
    private String id;
    private UserType userType;
    private String name;
    private String surname;
    private String position;
}
