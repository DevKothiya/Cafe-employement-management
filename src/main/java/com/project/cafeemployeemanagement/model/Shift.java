package com.project.cafeemployeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roster_id")
    private Roster roster;

    @OneToMany(mappedBy = "shift",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<EmployeeShift> employeeShifts = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String note;

    public Shift(Roster roster, Date date, String note) {
        this.roster = roster;
        this.date = date;
        this.note = note;
    }

    public void addEmployeeShift(EmployeeShift employeeShift, Employee employee) {
        employeeShift.setEmployee(employee);
        employeeShift.setShift(this);
        employeeShifts.add(employeeShift);
    }

    public void removeEmployeeShift(EmployeeShift employeeShift) {
        employeeShifts.remove(employeeShift);
        employeeShift.setShift(null);
        employeeShift.setEmployee(null);
    }
}
