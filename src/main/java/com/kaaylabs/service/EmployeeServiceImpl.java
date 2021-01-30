package com.kaaylabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaaylabs.entity.Employee;
import com.kaaylabs.repository.IEmployeeRepository;
import com.kaaylabs.repository.IEmployeeRepository.EmployeeDetails;



@Service
public class EmployeeServiceImpl implements IEmployeeService  {
	
	@Autowired
	public IEmployeeRepository employeeRepository;

	@Override
	public String saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepository.save(emp).getName();
	}

	
	@Override
	public List<EmployeeDetails> getByOrganization(String organization) {
		// TODO Auto-generated method stub
		return employeeRepository.findByOrganization(organization);
	}

	
	
	
	
}
