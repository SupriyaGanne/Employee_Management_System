package com.sgprojects.Employee_Management_System.controller;

import com.sgprojects.Employee_Management_System.dto.EmployeeDto;
import com.sgprojects.Employee_Management_System.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping

    //Build Add employee REST_API
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    //Build Get Employee REST_API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }

    //Build Get All Employees REST_API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getALlEmployees() {
        List<EmployeeDto>employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);

    }
    //Build delete employee REST_API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }
}
