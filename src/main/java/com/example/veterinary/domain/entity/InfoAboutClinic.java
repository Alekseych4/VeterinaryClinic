package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class InfoAboutClinic extends EntityBase {

    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "info", nullable = false)
    private String info;

    public InfoAboutClinic(UUID id, String info, Date publicationDate) {
        super(id);
        this.publicationDate = publicationDate;
        this.info = info;
    }

    protected InfoAboutClinic(){}
}
