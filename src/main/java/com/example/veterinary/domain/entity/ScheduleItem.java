package com.example.veterinary.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class ScheduleItem extends EntityBase{

    @Column(name = "time_start", nullable = false)
    private Date timeStart;
    @Column(name = "duration", nullable = false)
    private long duration;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @OneToOne(mappedBy = "scheduleItem")
    private Appointment appointment;

    public ScheduleItem(UUID id, Date timeStart, long duration, String description) {
        super(id);
        this.timeStart = timeStart;
        this.duration = duration;
        this.description = description;
    }

    protected ScheduleItem(){}
}
