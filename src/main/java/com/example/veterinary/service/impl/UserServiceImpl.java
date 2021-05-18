package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.domain.entity.Client;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.domain.entity.User;
import com.example.veterinary.exception.authentication.NoSuchUserException;
import com.example.veterinary.repository.UserRepository;
import com.example.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(UserCredentialsDto userCredentialsDto) {
        User user = null;

        if (userCredentialsDto.getUserRole().equals(UserRole.CLIENT)) {
            user = new Client(userCredentialsDto.getEmail(), passwordEncoder.encode(userCredentialsDto.getPassword()),
                    userCredentialsDto.getUserRole());
        } else {
            user = new Staff(userCredentialsDto.getEmail(), passwordEncoder.encode(userCredentialsDto.getPassword()),
                    userCredentialsDto.getUserRole());
        }
        userRepository.save(user);
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        userRepository.findByEmail(email).orElseThrow(() ->  new NoSuchUserException());
        return true;
    }
}
