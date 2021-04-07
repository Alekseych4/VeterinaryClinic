package com.example.veterinary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class InfoAboutClinic {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(name = "publication_date")
    private Timestamp publicationDate;
    @Column(name = "info", nullable = false)
    private String info;

    public InfoAboutClinic(Timestamp publicationDate, String info) {
        this.publicationDate = publicationDate;
        this.info = info;
    }

    protected InfoAboutClinic(){}
}
