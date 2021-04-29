package com.example.veterinary.repository;

import com.example.veterinary.domain.entity.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, UUID> {
}
