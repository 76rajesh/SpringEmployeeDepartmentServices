package com.micro.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.departmentservice.dto.DepartmentDto;
import com.micro.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
	
	
	private DepartmentService deptservice;
	
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto deptdto = deptservice.saveDepartment(departmentDto);
		
		return new ResponseEntity<DepartmentDto>(deptdto,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<DepartmentDto> getDeptById(@PathVariable Long id){
		
		DepartmentDto deptDto = deptservice.getDeptById(id);
		
		return new ResponseEntity<DepartmentDto>(deptDto,HttpStatus.OK);
		
	}
	@GetMapping("{deptCode}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String deptCode){
		
		DepartmentDto deptDto = deptservice.getdepartmentCodeById(deptCode);
		
		return new ResponseEntity<DepartmentDto>(deptDto,HttpStatus.OK);
		
	}

}
