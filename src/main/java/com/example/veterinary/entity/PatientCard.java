package com.example.veterinary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class PatientCard {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(name = "client_id", nullable = false)
    private UUID clientId;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private double weight;
    @Column(name = "animal_type")
    private String animalType;

    public PatientCard(UUID clientId, int age, String name, double weight, String animalType) {
        this.clientId = clientId;
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.animalType = animalType;
    }

    protected PatientCard() {
    }
}
