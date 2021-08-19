package com.dan.demo.repository;

import com.dan.demo.model.EmployeeDto;

import java.util.List;

public interface EmployeeRepository {
    EmployeeDto getById(long id);

    List<EmployeeDto> getAll();

    EmployeeDto add(EmployeeDto employeeDto);

    EmployeeDto update(EmployeeDto employeeDto);

    void delete(long id);
}
