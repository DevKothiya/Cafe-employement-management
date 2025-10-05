package com.project.cafeemployeemanagement.payload;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AvailabilityResponse {

    private Long id;

    private String day;

    private int startHour;

    private int startMinute;

    private int endHour;

    private int endMinute;

    private boolean isAvailable;

}
