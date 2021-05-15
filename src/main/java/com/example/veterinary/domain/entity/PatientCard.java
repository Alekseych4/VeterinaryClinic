package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class PatientCard extends EntityBase {

    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private double weight;
    @Column(name = "animal_type")
    private String animalType;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @BatchSize(size = 5)
    @OneToMany(mappedBy = "patientCard")
    private Collection<Appointment> appointments;

    public PatientCard(UUID id, int age, String name, double weight, String animalType) {
        super(id);
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.animalType = animalType;
    }

    protected PatientCard() {
    }
}
