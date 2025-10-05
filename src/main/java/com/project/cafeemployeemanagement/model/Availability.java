package com.project.cafeemployeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="availability")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private int startHour;

    private int startMinute;

    private int endHour;

    private int endMinute;

    private boolean isAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;


    public Availability(String day, int startHour, int startMinute, int endHour, int endMinute, boolean isAvailable) {
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.isAvailable = isAvailable;
    }

    public Availability(Long id, String day, int startHour, int startMinute, int endHour, int endMinute, boolean isAvailable, Employee employee) {
        this.id = id;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.employee = employee;
        this.isAvailable = isAvailable;
    }

    public Availability(Long id, String day, int startHour, int startMinute, int endHour, int endMinute, boolean isAvailable, Employee employee, Date effectiveDate) {
        this.id = id;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.employee = employee;
        this.isAvailable = isAvailable;
        this.effectiveDate = effectiveDate;
    }

}
