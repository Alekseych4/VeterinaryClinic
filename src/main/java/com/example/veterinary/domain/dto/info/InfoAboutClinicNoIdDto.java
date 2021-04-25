package com.example.veterinary.domain.dto.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoAboutClinicNoIdDto {
    private String info;
    private long publicationDate;
}
