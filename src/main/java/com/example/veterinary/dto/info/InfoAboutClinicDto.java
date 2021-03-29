package com.example.veterinary.dto.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class InfoAboutClinicDto {
    private String id;
    private String info;
}
