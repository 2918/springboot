package com.springboot.examples.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.examples.service.CustomerService;
import com.springboot.examples.to.CustomerResponse;
import com.springboot.examples.to.CustomerTO;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@GetMapping(value="/customerform")
	public String customerForm() {
		return "customerform";
	}
	
	@PostMapping(value="/saveCustomer", consumes="application/json", produces="application/json")
	@ResponseBody
	public CustomerResponse saveCustomer(@RequestBody @Valid CustomerTO customerTO, BindingResult result) {
		System.out.println(customerTO);
		
		CustomerResponse response = new CustomerResponse();
		
		if(result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream()
		               						   .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else {
			response.setValidated(true);
			
			boolean status = customerService.saveCustomer(customerTO);
			if(status)
				response.setStatusMessage("Customer record saved successfully");	
			else
				response.setStatusMessage("Error while saving customer record");
		}
		return response;
	}
	
	
	@GetMapping(value="/viewCustomerForm")
	public String viewCustomerForm() {
		return "viewcustomerform";
	}
	
	@GetMapping(value="/getCustomer", produces="application/json")
	@ResponseBody
	public CustomerResponse getCustomer(@RequestParam String customerId) {
		
		CustomerResponse response = new CustomerResponse();

		CustomerTO customerTO = customerService.getCustomer(customerId);
		
		System.out.println("contnroller" + customerTO);
		if(customerTO == null) {
			response.setValidated(false);
			response.setStatusMessage("CustomerID-" +customerId + " doesn't exist");
		}
		else{
			response.setCustomerTO(customerTO);
			response.setValidated(true);
		}
		return response;
	}
	
	@PostMapping(value="/updateCustomer", consumes="application/json", produces="application/json")
	@ResponseBody
	public CustomerResponse updateCustomer(@RequestBody @Valid CustomerTO customerTO, BindingResult result) {
		
		CustomerResponse response = new CustomerResponse();
		
		if(result.hasErrors()){
			Map<String, String> errors = result.getFieldErrors().stream()
		               .collect(
		                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
		                 );
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else{
			response.setValidated(true);
			boolean updateStatus = customerService.updateCustomer(customerTO);
			if(updateStatus)
				response.setStatusMessage("Customer record updated successfully");
			else
				response.setStatusMessage("Error updating customer record");
		}
		return response;
	}

	
	@GetMapping(value="/getCustomers", produces="application/json")
	@ResponseBody
	public List<CustomerTO> getCustomers() {
		return customerService.getCustomers();
	}
	
	
	
}
