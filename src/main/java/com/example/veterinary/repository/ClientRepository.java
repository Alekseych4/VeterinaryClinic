package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findByName(String name);

    Client findByEmail(String email);
}
