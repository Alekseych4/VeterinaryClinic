package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class CardRecord extends EntityBase {

    @Column(name = "date")
    private Date date;
    @Column(name = "diagnose")
    private String diagnose;
    @Column(name = "description")
    private String description;
    @Column(name = "prescription")
    private String prescription;
    @ManyToOne
    @JoinColumn(name = "patient_card_id")
    private PatientCard patientCard;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;


    public CardRecord(UUID id, Date date, String diagnose, String description, String prescription) {
        super(id);
        this.date = date;
        this.diagnose = diagnose;
        this.description = description;
        this.prescription = prescription;
    }

    protected CardRecord() {
    }
}
