package com.springboot.examples.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@Column(name="CUSTOMERID")
	private String customerId;
	
	@Column(name="CUSTOMERNAME")
	private String customerName;
	
	@Column(name="OCCUPATION")
	private String occupation;
	
	@Column(name="QUALIFICATION")
	private String qualification;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="customer")
	Address address;
	
	public Customer() {}

	public Customer(String customerId, String customerName, String occupation, String qualification) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.occupation = occupation;
		this.qualification = qualification;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", occupation=" + occupation
				+ ", qualification=" + qualification + "]";
	}
	
}
