package com.example.veterinary.domain.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientCardDto extends PatientCardNoIdDto{
    private String id;

    public PatientCardDto(String id, String clientId, String age, String name, String weight, String animalType) {
        super(clientId, age, name, weight, animalType);
        this.id = id;
    }
}
