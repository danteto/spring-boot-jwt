package com.dan.demo.repository;

import com.dan.demo.model.EmployeeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class EmployeeRepositoryTest {

    private EmployeeRepository employeeRepository;

    @BeforeEach
    void init() {
        employeeRepository = new EmployeeRepositoryImpl();
    }

    @Test
    void addEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");

        employeeRepository.add(employeeDto);

        assertThat(employeeRepository.getById(1L).getFirstname().equals("Alex"));
    }

    @Test
    void getEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");

        employeeRepository.add(employeeDto);
        EmployeeDto receivedEmployeeDto = employeeRepository.getById(1L);

        assertThat(receivedEmployeeDto.getOrg().equals(employeeDto.getOrg()));
    }

    @Test
    void updateEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");

        employeeRepository.add(employeeDto);
        EmployeeDto updatedEmployeeDto = employeeRepository.update(new EmployeeDto(1L, "Otto", "Malex", 28, "T-Systems"));

        assertThat(!employeeDto.getFirstname().equals(updatedEmployeeDto.getFirstname()));

    }

    @Test
    void deleteEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");

        employeeRepository.add(employeeDto);
        employeeRepository.delete(1L);

        assertThat(employeeRepository.getById(1L) == null);
    }


}

