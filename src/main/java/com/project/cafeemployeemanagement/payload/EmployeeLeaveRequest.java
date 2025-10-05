package com.project.cafeemployeemanagement.payload;

import lombok.Data;

@Data
public class EmployeeLeaveRequest {
    public Long id;

    private String fromDate;

    private String toDate;

    private Long numberOfOffDates;

    private String status;

}
