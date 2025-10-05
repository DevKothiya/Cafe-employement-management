package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RosterRequest {

    private Long id;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date fromDate;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date toDate;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date createdDate;

    private Long shopOwnerId;

    private List<ShiftRequest> shiftList = new ArrayList<>();

}
