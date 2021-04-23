package com.example.veterinary.domain.dto.patient;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CardRecordDto extends CardRecordNoIdDto {
    private UUID id;

    public CardRecordDto(UUID id, UUID patientCardId, UUID staffId, UUID appointmentId, String diagnose,
                         String description, String prescription) {
        super(patientCardId, staffId, appointmentId, diagnose, description, prescription);
        this.id = id;
    }
}
