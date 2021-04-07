package com.example.veterinary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CardRecord {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(name = "patient_card_id", nullable = false)
    private UUID patientCardId;
    @Column(name = "staff_id", nullable = false)
    private UUID staffId;
    @Column(name = "diagnose", nullable = false)
    private String diagnose;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "prescription", nullable = false)
    private String prescription;

    public CardRecord(UUID patientCardId, UUID staffId, String diagnose, String description, String prescription) {
        this.patientCardId = patientCardId;
        this.staffId = staffId;
        this.diagnose = diagnose;
        this.description = description;
        this.prescription = prescription;
    }

    protected CardRecord() {
    }
}
