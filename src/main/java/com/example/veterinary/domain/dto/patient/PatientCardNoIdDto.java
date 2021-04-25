package com.example.veterinary.domain.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PatientCardNoIdDto {
    private UUID clientId;
    private int age;
    private String name;
    private double weight;
    private String animalType;
}
