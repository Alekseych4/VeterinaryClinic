package com.example.veterinary.domain.entity;

import com.example.veterinary.domain.dto.user.UserType;
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
public class Staff extends EntityBase{

    @Column(name = "user_type", nullable = false)
    @Enumerated
    private UserType userType;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "experience", nullable = false)
    private String experience;

    public Staff(UserType userType, String name, String surname, String position, String experience) {
        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.experience = experience;
    }

    protected Staff() {
    }
}
