package com.example.veterinary.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public class EntityBase {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();
}
