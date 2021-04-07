package com.example.veterinary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Appointment {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(name = "staff_id", nullable = false)
    private UUID staffId;
    @Column(name = "client_id")
    private UUID clientId;
    @Column(name = "time_start", nullable = false)
    private Timestamp timeStart;
    @Column(name = "time_end", nullable = false)
    private Timestamp timeEnd;
    @Column(name = "description")
    private String description;

    public Appointment(UUID staffId, Timestamp timeStart, Timestamp timeEnd, String description) {
        this.staffId = staffId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.description = description;
    }

    protected Appointment(){}
}
