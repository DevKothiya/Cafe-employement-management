package com.project.cafeemployeemanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "roster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date fromDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date toDate;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date createdDate;

    @OneToMany(mappedBy = "roster",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Shift> shifts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    public void addShift(Shift shift) {
        shifts.add(shift);
        shift.setRoster(this);
    }

    public void removeShift(Shift shift) {
        shifts.remove(shift);
        shift.setRoster(null);
    }

    private boolean isPublished;

    @Version
    private int version;

    public Roster(Date fromDate, Date toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.createdDate = new Date();
        this.isPublished = false;
    }

    public Roster(Date fromDate, Date toDate, Date createdDate, List<Shift> shifts) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.createdDate = createdDate;
        this.shifts = shifts;
        this.isPublished = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roster )) return false;
        return id != null && id.equals(((Roster) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
