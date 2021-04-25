package com.example.veterinary.domain.dto.patient;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PatientCardDto extends PatientCardNoIdDto{
    private UUID id;

    public PatientCardDto(UUID id, UUID clientId, int age, String name, double weight, String animalType) {
        super(clientId, age, name, weight, animalType);
        this.id = id;
    }
}
