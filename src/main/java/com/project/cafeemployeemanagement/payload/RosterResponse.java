package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.constant.Constants;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RosterResponse {
    private Long id;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    @JsonFormat(pattern= Constants.DATE_FORMAT)
    private Date fromDate;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    @JsonFormat(pattern= Constants.DATE_FORMAT)
    private Date toDate;

    private List<ShiftResponse> shiftList = new ArrayList<>();

}
