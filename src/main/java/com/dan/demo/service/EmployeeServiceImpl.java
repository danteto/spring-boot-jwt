package com.dan.demo.service;

import com.dan.demo.model.EmployeeDto;
import com.dan.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto getById(long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        return employeeRepository.add(employeeDto);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        return employeeRepository.update(employeeDto);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }
}
