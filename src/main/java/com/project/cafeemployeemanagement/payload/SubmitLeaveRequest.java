package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class SubmitLeaveRequest {
    private Long employeeId;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date fromDate;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date toDate;

    private String leaveType;

    private String leaveStatus;

    private String note;

}
