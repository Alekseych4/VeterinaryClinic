package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class EntityBase {
    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();
}
