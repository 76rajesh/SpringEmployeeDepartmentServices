package com.micro.employeeservice.service.implr;

import org.jvnet.hk2.annotations.Service;
import org.modelmapper.ModelMapper;

import com.micro.employeeservice.dto.EmployeeDto;
import com.micro.employeeservice.entity.Employee;
import com.micro.employeeservice.repository.EmployeeRepository;
import com.micro.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImple implements EmployeeService{
	
	private EmployeeRepository emprepo;
    
	private ModelMapper mapper;
	
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
		Employee emp=
		emprepo.findById(id).get();
		
		EmployeeDto empdto = mapper.map(emp, EmployeeDto.class);
		
		return empdto;
	}
	

}
