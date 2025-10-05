package com.project.cafeemployeemanagement.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.cafeemployeemanagement.model.Employee;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
public class UserPrincipal implements UserDetails {
    private Long id;

    private String firstName;
    private String lastName;

    private String email;

    @JsonIgnore
    private String password;

    private Long shopOwnerId;

    private Collection<? extends GrantedAuthority> authorities;

    private String role;

    private String type;

    private Date joinedDate;

    private String phoneNumber;

    private boolean isResigned;

    public UserPrincipal(Long id, String firstName, String lastName, String email, String password, Collection<? extends GrantedAuthority> authorities, Date joinedDate, String type, String role, Long shopOwnerId, String phoneNumber, boolean isResigned) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.authorities = authorities;
        this.shopOwnerId = shopOwnerId;
        this.role = role;
        this.type = type;
        this.joinedDate = joinedDate;
        this.phoneNumber = phoneNumber;
        this.isResigned = isResigned;
    }

    public static UserPrincipal create(Employee employee) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole().getName().name()));

        return new UserPrincipal(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPassword(),
                authorities,
                employee.getJoinedDate(),
                employee.getEmployeeType().getType().name(),
                employee.getRole().getName().name(),
                employee.getShopOwnerId(),
                employee.getPhoneNumber(),
                employee.isResigned()
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
