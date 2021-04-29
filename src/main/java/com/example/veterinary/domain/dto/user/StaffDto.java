package com.example.veterinary.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private UUID id;
    private UserType userType;
    private String name;
    private String surname;
    private String position;
    private String experience;
}
