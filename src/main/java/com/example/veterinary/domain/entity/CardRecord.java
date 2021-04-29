package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class CardRecord extends EntityBase {

    @Column(name = "patient_card_id", columnDefinition = "BINARY(16)")
    private UUID patientCardId;
    @Column(name = "staff_id", columnDefinition = "BINARY(16)")
    private UUID staffId;
    @Column(name = "appointment_id", columnDefinition = "BINARY(16)")
    private UUID appointmentId;
    @Column(name = "diagnose")
    private String diagnose;
    @Column(name = "description")
    private String description;
    @Column(name = "prescription")
    private String prescription;

    public CardRecord(UUID id, UUID patientCardId, UUID staffId, UUID appointmentId, String diagnose, String description, String prescription) {
        super(id);
        this.patientCardId = patientCardId;
        this.staffId = staffId;
        this.appointmentId = appointmentId;
        this.diagnose = diagnose;
        this.description = description;
        this.prescription = prescription;
    }

    protected CardRecord() {
    }
}
