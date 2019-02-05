package com.springboot.examples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.examples.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	public List<Customer>  findByCustomerName(String customerName);
	//public List<Customer>  findCustomerByCityorPincode(String city, String pincode);
	public List<Customer>  findByCustomerNameLike(String namePattern);
	public List<Customer>  findCustomerByAddressCity(String city);
	public List<Customer>  findCustomerByAddressPincode(String pincode);
	
}
