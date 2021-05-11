package com.example.veterinary.domain.entity;

import com.example.veterinary.domain.dto.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @OneToMany(mappedBy = "client")
    private Collection<PatientCard> patientCards;

    public Client(UUID id, String name, String surname) {
        super(id);
        this.name = name;
        this.surname = surname;
    }

    public Client(String email, String password, UserRole userRole) {
        super(email, password, userRole);
    }

    protected Client() {
    }
}
