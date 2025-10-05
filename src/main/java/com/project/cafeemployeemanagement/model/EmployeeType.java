package com.project.cafeemployeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length=60)
    private EmployeeTypeValues type;

    private int hourlyWorkPermit;

    @OneToMany(mappedBy = "employeeType",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setEmployeeType(this);
    }

    public void removeShift(Employee employee) {
        employees.remove(employee);
        employee.setEmployeeType(null);
    }

    public EmployeeType(EmployeeTypeValues values) {
        this.type = values;
        this.hourlyWorkPermit = values.equals(EmployeeTypeValues.PART_TIME_STUDENT) ? 20 : 0;
    }

}
