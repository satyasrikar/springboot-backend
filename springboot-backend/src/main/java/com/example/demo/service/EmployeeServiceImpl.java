package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	
	public Employee getEmployeeById(Integer id) {
		
		Employee employee = employeeRepository.findById(id).get();
				
		return employee;
	}
	
	public Employee updateEmployee(Employee employeeDetails) {
		
		
		
		return employeeRepository.save(employeeDetails);
		
		
	}
	
	
	
	public String deleteEmployee(Integer id) {
		
		Employee employee = employeeRepository.findById(id).get();
		
		
		employeeRepository.delete(employee);
		return "Employee_Deleted...";
	}
	
	
	
	
	
}
