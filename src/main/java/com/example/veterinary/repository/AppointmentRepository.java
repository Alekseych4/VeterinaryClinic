package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.Appointment;
import com.example.veterinary.domain.entity.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByPatientCard(PatientCard patientCard);
}
