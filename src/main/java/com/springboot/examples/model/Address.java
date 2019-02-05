package com.springboot.examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@Column(name="ADDRESSID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	
	@Column(name="DOORNO")
	private String doorno;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="PINCODE")
	private String pincode;
	
	@OneToOne
	@JoinColumn(name="CUSTOMERID")
	Customer customer;
	
	public Address() {}

	public Address(String doorno, String street, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.doorno = doorno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	public Address(int addressId, String doorno, String street, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.doorno = doorno;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getDoorno() {
		return doorno;
	}

	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", doorno=" + doorno + ", street=" + street + ", city=" + city
				+ ", pincode=" + pincode + "]";
	}
	
	
}
