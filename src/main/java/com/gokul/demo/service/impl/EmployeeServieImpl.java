package com.gokul.demo.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gokul.demo.exception.ResourceNotFoundException;
import com.gokul.demo.model.Employee;
import com.gokul.demo.repository.EmployeeRepositoy;
import com.gokul.demo.service.EmployeeService;
@Service
public class EmployeeServieImpl implements EmployeeService {
	
//	@Autowired
	//the class can only one dependency so spring is automatically connect this
	private EmployeeRepositoy employeeRepository;
	

	public EmployeeServieImpl( EmployeeRepositoy employeeRepository ) {
		super();
		this.employeeRepository=employeeRepository;
		// TODO Auto-generated constructor stub
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		//Optional<Employee> employee =employeeRepository.findById(id);
//	if(employee.isPresent()){
//		return employee.get();
//		
//	}else {
//	}
		return employeeRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Employee","id",id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whwether with given id is exist in DB or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee","id",id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist or not
		
		employeeRepository.findById(id).orElseThrow(()
				->new ResourceNotFoundException("Employee","id",id));
		
		employeeRepository.deleteById(id);
		
	}



	

}
