package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Appointment extends EntityBase {

    private UUID scheduleItemId;
    private UUID clientId;

    public Appointment(UUID id, UUID scheduleItemId, UUID clientId) {
        super(id);
        this.scheduleItemId = scheduleItemId;
        this.clientId = clientId;
    }

    protected Appointment(){}
}
