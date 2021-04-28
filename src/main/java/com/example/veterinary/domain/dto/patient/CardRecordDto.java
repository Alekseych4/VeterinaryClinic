package com.example.veterinary.domain.dto.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardRecordDto {
    private UUID id;
    private UUID patientCardId;
    private UUID staffId;
    private UUID appointmentId;
    private String diagnose;
    private String description;
    private String prescription;
}
