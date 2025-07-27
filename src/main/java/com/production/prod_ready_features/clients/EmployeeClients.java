package com.production.prod_ready_features.clients;

import com.production.prod_ready_features.dto.EmployeeDto;

import java.util.List;

public interface EmployeeClients {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long employeeId);
    EmployeeDto createNewEmployee(EmployeeDto inputEmployee);
}
