package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	
	public List<Employee> getAllEmployees();
	

	public Employee createEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id);
	

	
	public Employee updateEmployee(Employee employeeDetails);

	public String deleteEmployee(Integer id);


	
}
