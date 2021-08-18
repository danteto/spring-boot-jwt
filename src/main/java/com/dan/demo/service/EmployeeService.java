package com.dan.demo.service;

import com.dan.demo.model.EmployeeDto;

public interface EmployeeService {
    EmployeeDto getById(long id);

    EmployeeDto add(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    void delete(long id);
}
