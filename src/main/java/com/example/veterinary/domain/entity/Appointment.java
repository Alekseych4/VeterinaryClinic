package com.example.veterinary.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Appointment extends EntityBase{

    @Column(name = "staff_id", columnDefinition = "BINARY(16)")
    private UUID staffId;
    @Column(name = "client_id", columnDefinition = "BINARY(16)")
    private UUID clientId;
    @Column(name = "time_start", nullable = false)
    private Date timeStart;
    @Column(name = "duration", nullable = false)
    private Date duration;
    @Column(name = "description")
    private String description;

    public Appointment(UUID staffId, Date timeStart, Date duration, String description) {
        this.staffId = staffId;
        this.timeStart = timeStart;
        this.duration = duration;
        this.description = description;
    }

    protected Appointment(){}
}
