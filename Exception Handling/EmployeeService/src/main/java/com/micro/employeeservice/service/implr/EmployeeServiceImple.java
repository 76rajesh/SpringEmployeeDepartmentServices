package com.micro.employeeservice.service.implr;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.micro.employeeservice.dto.EmployeeDto;
import com.micro.employeeservice.entity.Employee;
import com.micro.employeeservice.exception.ResourceNotFoundException;
import com.micro.employeeservice.repository.EmployeeRepository;
import com.micro.employeeservice.service.EmployeeService;



@Service
public class EmployeeServiceImple implements EmployeeService{
	
	private EmployeeRepository emprepo;
    
	private ModelMapper mapper;
	
	public EmployeeServiceImple(EmployeeRepository emprepo, ModelMapper mapper) {
		super();
		this.emprepo = emprepo;
		this.mapper = mapper;
	}
	
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee emp = mapper.map(employeeDto, Employee.class);
		
		Employee savemep = emprepo.save(emp);
		
		EmployeeDto empDto = mapper.map(savemep, EmployeeDto.class);
		
		return empDto;
		
	}

	@Override
	public EmployeeDto getEmployeeByid(Long id) {
		// TODO Auto-generated method stub
		Employee emp=	emprepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(
				"Employee" ,"id",id));		
		
		EmployeeDto empdto = mapper.map(emp, EmployeeDto.class);
		
		return empdto;
		
	}

	

}
