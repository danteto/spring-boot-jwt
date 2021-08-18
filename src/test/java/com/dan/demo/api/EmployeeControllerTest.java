package com.dan.demo.api;

import com.dan.demo.model.EmployeeDto;
import com.dan.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EmployeeControllerTest.class)
@AutoConfigureMockMvc(addFilters = false)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto(1L, "Alex", "Malex", 28, "T-Systems");
        employeeService.add(employeeDto);

        MvcResult mvcResult = mockMvc.perform(get("/employee/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDto)))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponseBody =
                mvcResult.getResponse().getContentAsString();
        System.out.println(actualResponseBody);
    }

}
