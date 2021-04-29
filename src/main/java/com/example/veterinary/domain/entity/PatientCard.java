package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class PatientCard extends EntityBase{

    @Column(name = "client_id", columnDefinition = "BINARY(16)")
    private UUID clientId;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private double weight;
    @Column(name = "animal_type")
    private String animalType;

    public PatientCard(UUID id, UUID clientId, int age, String name, double weight, String animalType) {
        super(id);
        this.clientId = clientId;
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.animalType = animalType;
    }

    protected PatientCard() {
    }
}
