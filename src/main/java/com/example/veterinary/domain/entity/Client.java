package com.example.veterinary.domain.entity;

import com.example.veterinary.domain.dto.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class Client extends EntityBase {

    @Column(name = "user_type", nullable = false)
    @Enumerated
    private UserType userType;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;

    public Client(UUID id, UserType userType, String name, String surname) {
        super(id);
        this.userType = userType;
        this.name = name;
        this.surname = surname;
    }

    protected Client() {
    }
}
