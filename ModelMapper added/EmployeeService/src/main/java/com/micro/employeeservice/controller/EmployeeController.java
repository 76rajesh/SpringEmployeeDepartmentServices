package com.micro.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.employeeservice.dto.EmployeeDto;
import com.micro.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
	
	
	private EmployeeService empservice;
	
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody
			EmployeeDto empdto){
		
		EmployeeDto empdto1= empservice.createEmployee(empdto);
	    
		return new ResponseEntity<EmployeeDto>(empdto1, HttpStatus.CREATED);
	}
	
	@GetMapping("{empid}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("empid") long id)
	{
		EmployeeDto empdto = empservice.getEmployeeByid(id);
		
		return new ResponseEntity<EmployeeDto> (empdto, HttpStatus.OK);
		
		
		
		
	}

}
