package com.micro.departmentservice.service;

import com.micro.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDeptById(Long  id);

	DepartmentDto getdepartmentCodeById(String code);
	
	
	

}
