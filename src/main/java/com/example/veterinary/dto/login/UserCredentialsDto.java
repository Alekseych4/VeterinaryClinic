package com.example.veterinary.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class UserCredentialsDto {
    private String login;
    private String password;
}
