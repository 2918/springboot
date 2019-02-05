package com.springboot.examples.to;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

public class ClaimTO {

	@Digits(integer=5,fraction=0, message="Enter 5 digit policyNo")
	private int policyNo;
	
	@NotEmpty(message="cannot be empty")
	private String customerName;

	@Positive(message="Invalid premium amount")
	private double claimAmount;
	
	@PastOrPresent(message="Cannot be a future date")
	private Date claimDate;
	
	public ClaimTO(){}

	public ClaimTO(@Digits(integer = 5, fraction = 0, message = "Enter 5 digit policyNo") int policyno,
			@NotEmpty(message = "cannot be empty") String customerName,
			@Positive(message = "Invalid premium amount") double claimAmount,
			@PastOrPresent(message = "Cannot be a future date") Date claimDate) {
		super();
		this.policyNo = policyno;
		this.customerName = customerName;
		this.claimAmount = claimAmount;
		this.claimDate = claimDate;
	}


	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyno) {
		this.policyNo = policyno;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	@Override
	public String toString() {
		return "ClaimTO [policyno=" + policyNo + ", customerName=" + customerName + ", claimAmount=" + claimAmount
				+ ", claimDate=" + claimDate + "]";
	}


}
