package com.project.cafeemployeemanagement.model;

import com.project.cafeemployeemanagement.util.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee_shift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeShift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    private float workedHours;

    private String note;

    public EmployeeShift(Date start, Date end, String note) {
        this.start = start;
        this.end = end;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeShift employeeShift = (EmployeeShift) o;
        return Objects.equals(employee.getId(), employeeShift.employee.getId()) && Objects.equals(shift.getId(), employeeShift.shift.getId());
    }

    public void addEmployeeShift(Shift shift, Employee employee) {
        setEmployee(employee);
        setShift(shift);
    }

    public void removeEmployeeShift() {
        setEmployee(null);
        setShift(null);
    }
}
