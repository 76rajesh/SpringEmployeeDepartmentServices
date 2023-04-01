package com.micro.departmentservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.micro.departmentservice.dto.DepartmentDto;
import com.micro.departmentservice.entity.Department;
import com.micro.departmentservice.exception.ResourceNotFoundException;
import com.micro.departmentservice.repository.DepartmentRepository;
import com.micro.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImple implements DepartmentService{
	
	
	private DepartmentRepository departmentrepo;
    
	private ModelMapper mapper;
	
	
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		 
		//department dto to department jpa entity
		
		Department department = mapper.map(departmentDto, Department.class);
		
		Department savedDept =  departmentrepo.save(department);
		
		DepartmentDto deptdto =mapper.map(savedDept, DepartmentDto.class);
		
		return deptdto;
	}


	@Override
	public DepartmentDto getDeptById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Department> dept = departmentrepo.findById(id);
		
		DepartmentDto deptdto =mapper.map(dept, DepartmentDto.class);
		
		return deptdto;
	}

    
	public DepartmentDto getdepartmentCodeById(String code) {
		// TODO Auto-generated method stub
         
	
		Department dept =departmentrepo.findByDepartmentCode(code);
		if(dept==null) {
			throw new ResourceNotFoundException("Department code is not present");
		}
		DepartmentDto deptdto = mapper.map(dept, DepartmentDto.class);

		return deptdto;
	}

}
