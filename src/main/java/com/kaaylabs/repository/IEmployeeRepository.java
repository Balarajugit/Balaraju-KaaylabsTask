package com.kaaylabs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaaylabs.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public interface EmployeeDetails{
		public int getId();
		public String getName();
		public String getContact();
		public String getAddress();
	}
	

	
	public List<EmployeeDetails> findByOrganization(String organization);
	
	
}
