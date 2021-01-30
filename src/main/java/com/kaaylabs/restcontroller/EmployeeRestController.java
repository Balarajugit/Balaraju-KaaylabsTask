package com.kaaylabs.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaaylabs.entity.Employee;
import com.kaaylabs.repository.IEmployeeRepository.EmployeeDetails;
import com.kaaylabs.service.IEmployeeService;
import com.kaaylabs.validation.EmployeeValidator;


@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	public EmployeeValidator employeeValidator;
	
	@Autowired
	public IEmployeeService employeeService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerEmployeeDetails(@RequestBody Employee employee,Errors error) {
		ResponseEntity<?> res=null;
		try {
			employeeValidator.validate(employee, error);
			if(error.hasErrors()) {
				res=new ResponseEntity<FieldError>(error.getFieldError(), HttpStatus.BAD_REQUEST);
			}
			else {
				String name=employeeService.saveEmployee(employee);
	
				res=new ResponseEntity<String>(name+" details has been saved sucessfully",HttpStatus.OK);
			}
		} catch (Exception e) {
			res=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return res;
	}
	
	@GetMapping("/search/{organization}")
	public ResponseEntity<?> findByOrganization(@PathVariable("organization") String company){
		ResponseEntity<?> res=null;
		 try {
			
			List<EmployeeDetails> list = employeeService.getByOrganization(company);
			if(!list.isEmpty()) {
			res=new ResponseEntity<List<EmployeeDetails>>(list, HttpStatus.OK);
			}
			else {
				res=new ResponseEntity<String>("No data found", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			res=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return res;
		
	}
	


	
}
