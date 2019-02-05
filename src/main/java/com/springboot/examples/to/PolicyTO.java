package com.springboot.examples.to;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

public class PolicyTO {

	@Digits(integer=5,fraction=0, message="Enter 5 digit policyNo")
	private int policyno;
	
	@Positive(message="Invalid premium amount")
	private double premium;
	
	@PastOrPresent(message="Cannot be a future date")
	private Date issueDate;
	
	@Future(message="Must be a future date")
	private Date nextPremiumDate;
	
	@NotEmpty(message="cannot be empty")
	private String policyTerm;
	
	String customerId;
	
	public PolicyTO(){}

	public PolicyTO(@Digits(integer = 5, fraction = 0, message = "Enter 5 digit policyNo") int policyno,
			@Positive(message = "Invalid premium amount") double premium,
			@PastOrPresent(message = "Cannot be a future date") Date issueDate,
			@Future(message = "Must be a future date") Date nextPremiumDate,
			@NotEmpty(message = "cannot be empty") String policyTerm, String customerId) {
		super();
		this.policyno = policyno;
		this.premium = premium;
		this.issueDate = issueDate;
		this.nextPremiumDate = nextPremiumDate;
		this.policyTerm = policyTerm;
		this.customerId = customerId;
	}

	public int getPolicyno() {
		return policyno;
	}

	public void setPolicyno(int policyno) {
		this.policyno = policyno;
	}


	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getNextPremiumDate() {
		return nextPremiumDate;
	}

	public void setNextPremiumDate(Date nextPremiumDate) {
		this.nextPremiumDate = nextPremiumDate;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "PolicyTO [policyno=" + policyno +  ", premium=" + premium
				+ ", issueDate=" + issueDate + ", nextPremiumDate=" + nextPremiumDate + ", policyTerm=" + policyTerm
				+ ", customerId=" + customerId + "]";
	}
	

}
