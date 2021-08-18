package com.dan.demo.repository;

import com.dan.demo.model.EmployeeDto;

public interface EmployeeRepository {
    EmployeeDto getById(long id);

    EmployeeDto add(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    void delete(long id);
}
