package com.project.cafeemployeemanagement.payload;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeLeaveInfoResponse {

    private int pendingLeave;

    private int leaveBalance;

    private List<EmployeeLeaveRequest> leaveRequests = new ArrayList<>();

    public void addLeaveRequest(EmployeeLeaveRequest employeeLeaveRequest) {
        this.leaveRequests.add(employeeLeaveRequest);
    }

}
