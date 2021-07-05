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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employees")
	 public List<Employee> viewAllEmployeeList(){
		 return employeeService.getAllEmployees();
	 }
	
	
	@PostMapping("/employees")

	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.createEmployee(employee);	}


	
	
	@GetMapping("/employees/{id}")
	public Employee findEmployee(@PathVariable("id") Integer id) {
	return employeeService.getEmployeeById(id);
	}

	
	
	@PostMapping("/update")
	public Employee editEmployee(@RequestBody Employee employee)
	{
	System.out.print("Updating Employee...");
	return employeeService.updateEmployee(employee);	}


	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
	System.out.print("Deleting Employee with id= " + id);
	return employeeService.deleteEmployee(id);
	
}



}

