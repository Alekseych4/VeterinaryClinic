package com.example.veterinary.domain.dto.authentication;

import com.example.veterinary.domain.dto.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.usertype.UserType;

import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class AuthResponseDto {
    private UUID id;
    private String token;
    private UserRole userRole;
}
