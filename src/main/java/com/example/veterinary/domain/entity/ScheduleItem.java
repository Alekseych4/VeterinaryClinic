package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class ScheduleItem extends EntityBase{

    @Column(name = "staff_id", columnDefinition = "BINARY(16)")
    private UUID staffId;
    @Column(name = "time_start", nullable = false)
    private Date timeStart;
    @Column(name = "duration", nullable = false)
    private long duration;
    @Column(name = "description")
    private String description;

    public ScheduleItem(UUID id, UUID staffId, Date timeStart, long duration, String description) {
        super(id);
        this.staffId = staffId;
        this.timeStart = timeStart;
        this.duration = duration;
        this.description = description;
    }

    protected ScheduleItem(){}
}
