package com.example.veterinary.domain.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientCardDto {
    private UUID id;
    private UUID clientId;
    private int age;
    private String name;
    private double weight;
    private String animalType;
}
