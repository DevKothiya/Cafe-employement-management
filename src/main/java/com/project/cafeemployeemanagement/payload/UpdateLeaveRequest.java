package com.project.cafeemployeemanagement.payload;

import lombok.Data;

@Data
public class UpdateLeaveRequest {

    private Long managerId;

    private Long leaveRequestId;

    private String note;

}
