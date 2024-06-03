package com.sgprojects.Employee_Management_System.service;

import com.sgprojects.Employee_Management_System.dto.EmployeeDto;
import com.sgprojects.Employee_Management_System.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);



}
