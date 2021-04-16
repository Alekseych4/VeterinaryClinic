package com.example.veterinary.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
public class InfoAboutClinic {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();
//    @Column(name = "publication_date")
//    private Timestamp publicationDate;
    @Column(name = "info", nullable = false)
    private String info;

    public InfoAboutClinic(String info) {
//        this.publicationDate = publicationDate;
        this.info = info;
    }

    protected InfoAboutClinic(){}
}
