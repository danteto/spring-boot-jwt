package com.dan.demo.api;


import com.dan.demo.model.EmployeeDto;
import com.dan.demo.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/Employee")
@Api(tags = "employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "${EmployeeController.getById}")
    public EmployeeDto getById(@RequestParam long ID) {
        try {
            return employeeService.getById(ID);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", e);
        }
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiOperation(value = "${EmployeeController.add}")
    public void add(EmployeeDto employeeDto) {
        employeeService.add(employeeDto);
    }

    @PutMapping
    @ApiOperation(value = "${EmployeeController.update}")
    public void update(EmployeeDto employeeDto) {
        employeeService.update(employeeDto);
    }

    @DeleteMapping
    @ApiOperation(value = "${EmployeeController.delete}")
    public void delete(EmployeeDto employeeDto) {
        employeeService.delete(employeeDto.getID());
    }
}
