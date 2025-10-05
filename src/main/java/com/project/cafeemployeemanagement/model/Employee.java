package com.project.cafeemployeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String phoneNumber;

    private String email;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    private double hourlyRate;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<EmployeeShift> employeeShifts = new ArrayList<>();

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Availability> availabilityList = new ArrayList<>();

    private Long shopOwnerId;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Roster> rostersList = new ArrayList<>();

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    private int annualLeaveBalance = 0;

    private boolean isResigned;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joinedDate;

    public Employee(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String phoneNumber, @NotBlank @Email String email, String password, int i, Long shopOwnerId, boolean b) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.password=password;
        this.shopOwnerId=shopOwnerId;
        this.isResigned=b;
    }

    public void setRostersList(Roster roster) {
        this.rostersList.add(roster);
        roster.setEmployee(this);
    }

    public void removeRoster(Roster roster) {
        this.rostersList.remove(roster);
        roster.setEmployee(null);
    }


    public void addEmployeeShift(EmployeeShift employeeShift, Employee employee) {
        employeeShift.setEmployee(employee);
        employeeShift.setEmployee(this);
        employeeShifts.add(employeeShift);
    }

    public void removeEmployeeShift(EmployeeShift employeeShift) {
        employeeShifts.remove(employeeShift);
        employeeShift.setShift(null);
        employeeShift.setEmployee(null);
    }

    public void setAvailabilityList(List<Availability> availabilityList) {
        this.availabilityList.clear();

        if (availabilityList == null || availabilityList.isEmpty()) {
            return;
        }

        availabilityList.forEach(availability -> availability.setEmployee(this));
        this.availabilityList.addAll(availabilityList);
    }

    public void addAvailability(Availability availability) {
        this.availabilityList.add(availability);
        availability.setEmployee(this);
    }

    public void removeAvailability(Availability availability) {
        this.availabilityList.remove(availability);
        availability.setEmployee(null);
    }

    public void addLeaveRequests(LeaveRequest leaveRequest) {
        this.leaveRequests.add(leaveRequest);
        leaveRequest.setEmployee(this);
    }

    public void removeLeaveRequests(LeaveRequest leaveRequest) {
        this.leaveRequests.remove(leaveRequest);
        leaveRequest.setEmployee(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee )) return false;
        return id != null && id.equals(((Employee) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }

}
