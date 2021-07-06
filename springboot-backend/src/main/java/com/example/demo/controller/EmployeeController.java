package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "EmployeeController")
@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ApiOperation(value = "Get list of Employees", response = Iterable.class, tags = "viewAllEmployee")
	@GetMapping("/employees")
	
	 public List<Employee> viewAllEmployeeList(){
		 return employeeService.getAllEmployees();
	 }
	
	@ApiOperation(value = "Add new Employee", response = Employee.class, tags = "addEmployee")
	@PostMapping("/employees")

	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);	}


	
	@ApiOperation(value = "Get an employee by ID", response = Employee.class, tags = "findEmployee")
	@GetMapping("/employees/{id}")
	public Employee findEmployee(@PathVariable("id") Integer id) {
	return employeeService.getEmployeeById(id);
	}

	
	@ApiOperation(value = "Update Employee information", response = Employee.class, tags = "updateEmployee")
	@PutMapping("/employees/update")
	public Employee editEmployee(@RequestBody Employee employee)
	{
	System.out.print("Updating Employee...");
	return employeeService.updateEmployee(employee);	}

	@ApiOperation(value = "Delete an Employee", response = Employee.class, tags = "deleteEmployee")
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
	System.out.print("Deleting Employee with id= " + id);
	return employeeService.deleteEmployee(id);
	
}



}

