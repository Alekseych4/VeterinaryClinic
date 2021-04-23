package com.example.veterinary.domain.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CardRecordNoIdDto {

    private UUID patientCardId;
    private UUID staffId;
    private UUID appointmentId;
    private String diagnose;
    private String description;
    private String prescription;
}
