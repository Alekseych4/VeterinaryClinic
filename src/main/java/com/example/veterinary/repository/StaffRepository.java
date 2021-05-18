package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    List<Staff> findByNameAndSurname(String name, String surname);
}
