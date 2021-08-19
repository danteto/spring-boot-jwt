package com.dan.demo.repository;

import com.dan.demo.model.EmployeeDto;
import com.dan.demo.security.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        }

        return employees.get(id);
    }

    @Override
    public List<EmployeeDto> getAll() {
        return new ArrayList<>(employees.values());
    }


    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        if (employees.containsKey(employeeDto.getID())) {
            log.error("Employee with id = " + employeeDto.getID() + " already exists");

            throw new CustomException("Employee already exists", HttpStatus.BAD_REQUEST);
        }
        log.debug(employeeDto.toString());
        employees.put(employeeDto.getID(), employeeDto);

        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        if (!employees.containsKey(employeeDto.getID())) {
            log.error("Employee with id = " + employeeDto.getID() + " does not exist");

            throw new CustomException("Employee does not exist", HttpStatus.BAD_REQUEST);
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
