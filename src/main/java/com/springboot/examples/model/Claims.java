package com.springboot.examples.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLAIMS")
public class Claims {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLAIMID")
	private int claimId;
	@Column(name="CLAIMAMOUNT")
	private double claimAmount;
	@Column(name="CLAIMDATE")
	private Date claimDate;
	
	@ManyToOne()
	@JoinColumn(name="POLICYNO")
	Policy policy;
	
	public Claims(){}

	public Claims(int claimId, double claimAmount, Date issueDate) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimDate = issueDate;
	} 

	public Claims(double claimAmount, Date issueDate) {
		super();
		this.claimAmount = claimAmount;
		this.claimDate = issueDate;
	} 

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
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

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Claims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", issueDate=" + claimDate + "]";
	}	
}
