package com.kaaylabs.service;

import java.util.List;

import com.kaaylabs.entity.Employee;
import com.kaaylabs.repository.IEmployeeRepository.EmployeeDetails;

public interface IEmployeeSevice {
	
	public String saveEmployee(Employee employee);
	
	public List<EmployeeDetails> getByOrganizationName(String organization);
	
	

}
