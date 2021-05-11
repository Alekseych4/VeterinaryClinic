package com.example.veterinary.repository;

import com.example.veterinary.domain.dto.user.UserRole;
import com.example.veterinary.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndUserRole(String email, UserRole userRole);
}
