package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateTimeDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeShiftRequest {

    @JsonDeserialize(using = CustomDateTimeDeserialize.class)
    private Date start;

    @JsonDeserialize(using = CustomDateTimeDeserialize.class)
    private Date end;

    private Long employeeId;

    private String note;

}
