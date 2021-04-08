package com.example.veterinary.domain.dto.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientCardDto extends PatientCardNoIdDto{
    private String id;
    private String clientId;
    private String age;
    private String name;
    private String weight;
    private String animalType;

    public PatientCardDto(String id, String clientId, String age, String name, String weight, String animalType) {
        super(clientId, age, name, weight, animalType);
        this.id = id;
    }
}
