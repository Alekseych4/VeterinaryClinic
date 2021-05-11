package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.domain.entity.Client;
import com.example.veterinary.domain.entity.Staff;
import com.example.veterinary.domain.entity.User;
import com.example.veterinary.repository.UserRepository;
import com.example.veterinary.security.JwtTokenService;
import com.example.veterinary.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    @Override
    public String signUp(UserCredentialsDto userCredentialsDto){
        User user = null;

        if (userCredentialsDto.getUserRole() != UserRole.CLIENT) {
            user = new Staff(userCredentialsDto.getEmail(), passwordEncoder.encode(userCredentialsDto.getPassword()),
                    userCredentialsDto.getUserRole());
        } else {
            user = new Client(userCredentialsDto.getEmail(), passwordEncoder.encode(userCredentialsDto.getPassword()),
                    userCredentialsDto.getUserRole());
        }

        userRepository.save(user);
        return getToken(userCredentialsDto);
    }

    @Override
    public String getToken(UserCredentialsDto userCredentialsDto) {
        User user = userRepository.findByEmail(userCredentialsDto.getEmail())
                .orElseThrow(() -> new RuntimeException("No such account"));

        if (!passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())){
            throw new RuntimeException("Wrong password/email combination");
        }

        return jwtTokenService.generateToken(user);
    }
}
