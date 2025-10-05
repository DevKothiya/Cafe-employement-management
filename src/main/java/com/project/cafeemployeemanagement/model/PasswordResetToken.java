package com.project.cafeemployeemanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "password_reset_token")
@Data
public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "employee_id")
    private Employee employee;

    private Date expiryDate;

    public PasswordResetToken() {}

    public PasswordResetToken(String token) {
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public PasswordResetToken(String token, Employee employee) {
        this.token = token;
        this.employee = employee;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
