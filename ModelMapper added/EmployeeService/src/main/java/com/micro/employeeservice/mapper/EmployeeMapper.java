package com.micro.employeeservice.mapper;

import com.micro.employeeservice.dto.EmployeeDto;
import com.micro.employeeservice.entity.Employee;

public class EmployeeMapper {
	
	public static Employee maptoEmployee(EmployeeDto empdto) {
		
		
		Employee emp = new Employee(
				empdto.getId(),
				empdto.getFirstName(),
				empdto.getLastName(),
				empdto.getEmail());
		return emp;
	}
	
	public static EmployeeDto maptoDto(Employee emp) {
	
		
		EmployeeDto empdto = new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail());
		
		return empdto;
		
	}

}
