package com.gokul.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gokul.demo.model.Employee;
import com.gokul.demo.service.EmployeeService;
@Controller
//@RestController internally have the @Controlller and @ResponseBody 
@RequestMapping("api/employees")
public class EmployeeController {
	@Autowired
	
	 private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		// TODO Auto-generated constructor stub
		this.employeeService=employeeService;
	} 
@PostMapping()
	 //build craete employee REST API
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
//builde get all employees
@GetMapping
public List<Employee> getAllEmployees(){
	return employeeService.getAllEmployee();
}
   //build get employee by id REST API
@GetMapping("{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
	return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
}
//build update employee REST API
@PutMapping("{id}")
//ResponseEntity we use to prefer the response of api
 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
	 return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
 }
//build  delete employee REST API
@DeleteMapping("{id}")
public ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
	employeeService.deleteEmployee(id);
	return new ResponseEntity<String>("Employee deleted sucessFully",HttpStatus.OK);
	
}
}
