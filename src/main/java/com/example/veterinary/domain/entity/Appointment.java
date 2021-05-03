package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Appointment extends EntityBase {

    @ManyToOne
    private PatientCard patientCard;
    @OneToOne
    private ScheduleItem scheduleItem;

    public Appointment(UUID id) {
        super(id);
    }

    protected Appointment(){}
}
