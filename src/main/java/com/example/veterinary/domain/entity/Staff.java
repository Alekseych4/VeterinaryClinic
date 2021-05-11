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
public class Staff extends User {

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

    public Staff(UUID id, String name, String surname, String position, String experience) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.experience = experience;
    }

    public Staff(String email, String password, UserRole userRole) {
        super(email, password, userRole);
    }

    protected Staff() {
    }
}
