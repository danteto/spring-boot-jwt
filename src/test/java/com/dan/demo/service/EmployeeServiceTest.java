package com.dan.demo.service;

import com.dan.demo.model.EmployeeDto;
import com.dan.demo.repository.EmployeeRepository;
import com.dan.demo.repository.EmployeeRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    private EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepositoryImpl.class);

    private EmployeeService employeeService;

    @BeforeEach
    void init() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    void addEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");
        when(employeeRepository.add(employeeDto)).thenReturn(employeeDto);

        EmployeeDto savedEmployeeDto = employeeService.add(employeeDto);

        assertThat(savedEmployeeDto.getID() == 1L);
    }

    @Test
    void getEmployee() {
        EmployeeDto employeeDto = new EmployeeDto(10L, "Alex", "Malex", 28, "T-Systems");
        when(employeeRepository.getById(10L)).thenReturn(employeeDto);

        EmployeeDto receivedEmployeeDto = employeeService.getById(10L);

        assertThat(receivedEmployeeDto.getID() == 10L);
    }

}
