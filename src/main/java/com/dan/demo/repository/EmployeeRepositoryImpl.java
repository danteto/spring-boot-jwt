package com.dan.demo.repository;

import com.dan.demo.model.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Long, EmployeeDto> employees;
    static final Logger log = LoggerFactory.getLogger(EmployeeRepositoryImpl.class);

    public EmployeeRepositoryImpl() {
        employees = new HashMap<>();
    }

    @Override
    public EmployeeDto getById(long id) {
        if (!employees.containsKey(id)) {
            log.error("Employee with id = " + id + " is not in the list");
            throw new IllegalArgumentException("Employee is not in the list");
        }

        return employees.get(id);
    }

    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        if (employees.containsKey(employeeDto.getID())) {
            log.error("Employee with id = " + employeeDto.getID() + " already exists");

            throw new IllegalArgumentException("Employee already exists");
        }
        log.debug(employeeDto.toString());
        employees.put(employeeDto.getID(), employeeDto);

        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        if (!employees.containsKey(employeeDto.getID())) {
            log.error("Employee with id = " + employeeDto.getID() + " does not exist");

            throw new IllegalArgumentException("Employee does not exist");
        }
        employees.put(employeeDto.getID(), employeeDto);

        return employeeDto;
    }

    @Override
    public void delete(long id) {
        if (!employees.containsKey(id)) {
            log.error("Employee with id = " + id + " does not exist");
        }

        employees.remove(id);
    }
}
