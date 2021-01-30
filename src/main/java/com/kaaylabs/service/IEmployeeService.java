package com.kaaylabs.service;

import java.util.List;

import com.kaaylabs.entity.Employee;
import com.kaaylabs.repository.IEmployeeRepository.EmployeeDetails;


public interface IEmployeeService {
	
	public String saveEmployee(Employee emp);
	
	public List<EmployeeDetails> getByOrganization(String organization);

}
