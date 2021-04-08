package com.example.veterinary.entity;

import com.example.veterinary.dto.user.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Client {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(name = "user_type", nullable = false)
    @Enumerated
    private UserType userType;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;

    public Client(UserType userType, String name, String surname) {
        this.userType = userType;
        this.name = name;
        this.surname = surname;
    }

    protected Client() {
    }
}
