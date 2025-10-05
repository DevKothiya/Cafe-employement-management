package com.project.cafeemployeemanagement.payload;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AvailabilityRequest {
    private List<AvailabilityResponse> availabilityList = new ArrayList<>();
    private Long employeeId;

}
