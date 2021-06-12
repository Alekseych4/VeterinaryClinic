package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.CardRecord;
import com.example.veterinary.domain.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface CardRecordRepository extends JpaRepository<CardRecord, UUID> {
    Collection<CardRecord> findByStaff(Staff staff);
}
