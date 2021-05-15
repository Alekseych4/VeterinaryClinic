package com.example.veterinary.converter.user;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.domain.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsDtoUserConverter implements Converter<UserCredentialsDto, User> {
    @Override
    public User convert(UserCredentialsDto source) {
        return User.builder()
                .email(source.getEmail())
                .password(source.getPassword())
                .userRole(source.getUserRole())
                .build();
    }
}
