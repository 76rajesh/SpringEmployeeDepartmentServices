package com.micro.departmentservice.mapper;

import com.micro.departmentservice.dto.DepartmentDto;
import com.micro.departmentservice.entity.Department;

public class DepartmentMapper {

	
	
	public static Department maptoDepartment(DepartmentDto userdto) {
		
		Department department = new Department(
				
				userdto.getId(),
				userdto.getDepartName(),
				userdto.getDepartmentCode(),
				userdto.getDepartmentDescription());
				
		return department;
		
	}
	
	public static DepartmentDto maptodto(Department department) {
		DepartmentDto departmentdto = new DepartmentDto(
				department.getId(),
				department.getDepartName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode());
		return departmentdto;
		
	}
}
