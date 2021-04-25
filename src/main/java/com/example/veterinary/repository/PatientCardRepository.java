package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientCardRepository extends JpaRepository<PatientCard, UUID> {
}
