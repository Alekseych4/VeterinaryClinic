package com.example.veterinary.domain.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private UUID id;
    private UUID scheduleItemId;
    private UUID clientId;

    public AppointmentDto(UUID scheduleItemId, UUID clientId) {
        this.scheduleItemId = scheduleItemId;
        this.clientId = clientId;
    }
}
