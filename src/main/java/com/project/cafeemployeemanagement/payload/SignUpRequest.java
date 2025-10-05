package com.project.cafeemployeemanagement.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class SignUpRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String type;

    @NotBlank
    private String role;

    private Long shopOwnerId;

}
