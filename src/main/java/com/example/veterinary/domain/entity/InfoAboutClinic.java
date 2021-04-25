package com.example.veterinary.domain.entity;

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
@Entity
public class InfoAboutClinic extends EntityBase {

    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "info", nullable = false)
    private String info;

    public InfoAboutClinic(String info, Date publicationDate) {
        this.publicationDate = publicationDate;
        this.info = info;
    }

    protected InfoAboutClinic(){}
}
