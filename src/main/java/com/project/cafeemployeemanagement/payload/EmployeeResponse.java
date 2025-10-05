package com.project.cafeemployeemanagement.payload;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.project.cafeemployeemanagement.util.CustomDateDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long shopOwnerId;

    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date joinedDate;

    private String type;

    private String role;

    private String phoneNumber;

    private boolean isResigned;

}
