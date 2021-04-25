package com.example.veterinary.domain.dto.info;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InfoAboutClinicDto extends InfoAboutClinicNoIdDto{
    private UUID id;

    public InfoAboutClinicDto(UUID id, String info, long publicationDate) {
        super(info, publicationDate);
        this.id = id;
    }
}
