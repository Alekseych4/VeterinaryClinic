package com.example.veterinary.domain.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class AuthResponseDto {
    private UUID id;
    private String token;
}
