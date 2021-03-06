package com.example.veterinary.domain.dto.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoAboutClinicDto {
    private UUID id;
    private String info;
    private Date publicationDate;
}
