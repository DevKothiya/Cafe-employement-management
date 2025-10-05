package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.constant.Constants;
import com.project.cafeemployeemanagement.util.CustomDateTimeDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class ShiftResponse {
    private Long id;

    @JsonDeserialize(using = CustomDateTimeDeserialize.class)
    private Date start;

    @JsonDeserialize(using = CustomDateTimeDeserialize.class)
    private Date end;

    private String title;

    private Long shiftId;

    private Long employeeId;

}
