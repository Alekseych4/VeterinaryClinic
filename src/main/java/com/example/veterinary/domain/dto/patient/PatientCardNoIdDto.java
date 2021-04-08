package com.example.veterinary.domain.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientCardNoIdDto {
    private String clientId;
    private String age;
    private String name;
    private String weight;
    private String animalType;
}
