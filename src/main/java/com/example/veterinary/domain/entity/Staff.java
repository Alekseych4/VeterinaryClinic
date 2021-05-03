package com.example.veterinary.domain.entity;

import com.example.veterinary.domain.dto.user.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class Staff extends EntityBase {

    @Column(name = "user_type")
    @Enumerated
    private UserType userType;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "position")
    private String position;
    @Column(name = "experience")
    private String experience;
    @OneToMany(mappedBy = "staff")
    private Collection<ScheduleItem> schedule;
    @OneToMany(mappedBy = "staff")
    private Collection<CardRecord> cardRecords;

    public Staff(UUID id, UserType userType, String name, String surname, String position, String experience) {
        super(id);
        this.userType = userType;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.experience = experience;
    }

    protected Staff() {
    }
}
