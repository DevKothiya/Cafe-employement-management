package com.project.cafeemployeemanagement.payload;

import lombok.Data;

@Data
public class LeaveRequestsResponse {
    private Long id;

    private String fromDate;

    private String toDate;

    private Long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private String employeePhoneNumber;

    private String note;
}
