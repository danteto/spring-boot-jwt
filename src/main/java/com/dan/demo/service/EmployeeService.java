package com.dan.demo.service;

import com.dan.demo.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getById(long id);

    List<EmployeeDto> getAll();

    EmployeeDto add(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    void delete(long id);
}
