package com.micro.employeeservice.service;

import com.micro.employeeservice.dto.EmployeeDto;


public interface EmployeeService {
	 
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeByid(Long id);
	

}
