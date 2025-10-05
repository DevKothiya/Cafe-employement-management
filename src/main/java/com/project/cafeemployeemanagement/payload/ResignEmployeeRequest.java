package com.project.cafeemployeemanagement.payload;

import lombok.Data;

import java.util.List;

@Data
public class ResignEmployeeRequest {
    private List<Long> employeesIdList;

}
