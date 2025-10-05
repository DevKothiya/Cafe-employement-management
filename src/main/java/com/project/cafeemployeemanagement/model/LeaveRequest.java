package com.project.cafeemployeemanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.cafeemployeemanagement.util.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="leave_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date toDate;

    private Long numberOfOffDates;

    @Enumerated(EnumType.STRING)
    @Column(length=60)
    private LeaveStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    private Long updatedManagerId;

    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public long getNumberOfOffDates() {
        return utils.getNumberOfDifferentDatesBetweenTwoLeaveDates(this.getFromDate(), this.getToDate());
    }
}
