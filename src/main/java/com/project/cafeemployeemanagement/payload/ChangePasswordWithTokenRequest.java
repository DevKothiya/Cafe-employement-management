package com.project.cafeemployeemanagement.payload;


import lombok.Data;

@Data
public class ChangePasswordWithTokenRequest {
    private Long employeeId;
    private String password;
    private String token;

}
