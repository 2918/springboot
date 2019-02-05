package com.springboot.examples.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.examples.model.Address;
import com.springboot.examples.model.Customer;
import com.springboot.examples.model.Policy;
import com.springboot.examples.repository.CustomerRepository;
import com.springboot.examples.repository.PolicyRepository;
import com.springboot.examples.to.CustomerTO;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PolicyRepository policyRepository;
	
	public Customer getCustomer(CustomerTO customerTO) {
		Customer customer = new Customer(customerTO.getCustomerId(), customerTO.getCustomerName(), customerTO.getOccupation(), customerTO.getQualification());
		Address address = new Address(customerTO.getDoorno(), customerTO.getStreet(), customerTO.getCity(), customerTO.getPincode());
		customer.setAddress(address); 
		address.setCustomer(customer);
		return customer;
	} 

	public CustomerTO getCustomerTO(Customer customer) {
		CustomerTO customerTO = new CustomerTO(customer.getCustomerId(), customer.getCustomerName(), customer.getOccupation(), customer.getQualification(), customer.getAddress().getDoorno(), customer.getAddress().getStreet(), customer.getAddress().getCity(), customer.getAddress().getPincode());
		customerTO.setAddressId(customer.getAddress().getAddressId());
		return customerTO;
	}
	
	public boolean saveCustomer(CustomerTO customerTO) {
		Customer customer = getCustomer(customerTO);
		try {
			customerRepository.save(customer);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	public CustomerTO getCustomer(String customerId) {		
		Optional<Customer> cust= customerRepository.findById(customerId);
		if(cust.isPresent()) {
			Customer customer = cust.get();
			CustomerTO customerTO = getCustomerTO(customer);
			return customerTO;
		}
		else{
			return null;
		}
	}
	
	public boolean updateCustomer(CustomerTO customerTO) {	
		try{
			Customer customer = getCustomer(customerTO);
			customer.getAddress().setAddressId(customerTO.getAddressId());
			customerRepository.save(customer);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	
	public List<CustomerTO> getCustomers(){
		
		List<Customer> custList = customerRepository.findAll();
		List<CustomerTO> custTOList = custList.stream()
		        						.map(customer -> {return getCustomerTO(customer);})
		        							.collect(Collectors.toList());
		
		return custTOList;
		//return null;
	}
	
	public CustomerTO getCustomer(int policyNo) {		
		
		Optional<Policy> optionalPolicy= policyRepository.findById(policyNo);
		
		if(optionalPolicy.isPresent()) {
			Policy policy = optionalPolicy.get();
			System.out.println(policy);
			CustomerTO customerTO = getCustomerTO(policy.getCustomer());
			System.out.println(customerTO);
			return customerTO;
		}
		else{
			System.out.println("null");
			return null;
		}
	}
	
	
}
