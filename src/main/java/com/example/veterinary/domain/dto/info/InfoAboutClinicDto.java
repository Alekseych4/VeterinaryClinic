package com.example.veterinary.domain.dto.info;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InfoAboutClinicDto extends InfoAboutClinicNoIdDto{
    private UUID id;
//    private String info;

    public InfoAboutClinicDto(UUID id, String info) {
        super(info);
        this.id = id;
    }
}
