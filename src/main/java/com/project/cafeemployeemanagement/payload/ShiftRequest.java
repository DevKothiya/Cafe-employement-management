package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ShiftRequest {

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date date;

    private List<EmployeeShiftRequest> employeeShifts = new ArrayList<>();

    private String note;
}
