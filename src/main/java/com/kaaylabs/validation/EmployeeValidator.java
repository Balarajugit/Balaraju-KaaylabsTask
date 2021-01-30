package com.kaaylabs.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kaaylabs.entity.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee=(Employee)target;
		
		
		if(!StringUtils.hasText(employee.getAddress())) {
			errors.rejectValue("address", "please enter your address");
		}
		else if(!StringUtils.hasText(employee.getOrganization())) {
			errors.rejectValue("organization", "please enter your Organization Name");
		}
		else if(!StringUtils.hasText(employee.getOrganizationaddress())) {
			errors.rejectValue("organizationaddress", "please enter your Organization address");
		}
		else if(!Pattern.matches("[0-9]{10}", employee.getContact())) {
			errors.rejectValue("contact", "enter valid contact number! try again");
		}
		else if(!Pattern.matches("[A-Z a-z]*", employee.getName())) {
			errors.rejectValue("name","enter only alphabets not numbers! try again");
		}

	}

}
