package com.example.veterinary.service.impl;

import com.example.veterinary.domain.dto.authentication.AuthResponseDto;
import com.example.veterinary.domain.dto.authentication.UserCredentialsDto;
import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.domain.entity.User;
import com.example.veterinary.exception.authentication.NoSuchUserException;
import com.example.veterinary.repository.UserRepository;
import com.example.veterinary.security.JwtTokenService;
import com.example.veterinary.service.AuthenticationService;
import com.example.veterinary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtTokenService jwtTokenService;

    @Override
    public AuthResponseDto signUp(UserCredentialsDto userCredentialsDto, UUID adminId){
        if (adminId == null) {
            if (userCredentialsDto.getUserRole() != null){
                throw new AccessDeniedException("No permission for a request");
            }
            userCredentialsDto.setUserRole(UserRole.CLIENT);
            userService.create(userCredentialsDto);
        } else {
            userRepository.findById(adminId)
                    .filter(user1 -> user1.getUserRole().equals(UserRole.ADMIN))
                    .orElseThrow(NoSuchUserException::new);

            userService.create(userCredentialsDto);
        }

        return signIn(userCredentialsDto);
    }

    @Override
    public AuthResponseDto signIn(UserCredentialsDto userCredentialsDto) {
        User user = userRepository.findByEmail(userCredentialsDto.getEmail())
                .orElseThrow(() -> new NoSuchUserException());

        if (!passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())){
            throw new NoSuchUserException("Wrong password/email combination");
        }

        String token = jwtTokenService.generateToken(user);
        return AuthResponseDto.builder()
                .id(user.getId())
                .token(token)
                .userRole(user.getUserRole())
                .build();
    }
}
