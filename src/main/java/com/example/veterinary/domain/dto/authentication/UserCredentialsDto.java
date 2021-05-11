package com.example.veterinary.domain.dto.authentication;

import com.example.veterinary.domain.dto.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class UserCredentialsDto {
    private String email;
    private String password;
    private UserRole userRole;
}
