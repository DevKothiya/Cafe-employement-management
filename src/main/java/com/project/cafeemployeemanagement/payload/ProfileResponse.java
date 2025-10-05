package com.project.cafeemployeemanagement.payload;

import lombok.Data;

@Data
public class ProfileResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String type;

}
