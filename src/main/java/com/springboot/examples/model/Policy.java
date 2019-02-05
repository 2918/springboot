package com.springboot.examples.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POLICY")
public class Policy {
 
	@Id
	@Column(name="POLICYNO")
	private int policyno;
	@Column(name="PREMIUM")
	private double premium;
	@Column(name="ISSUEDATE")
	private Date issueDate;
	@Column(name="NEXTPREMIUMDATE")
	private Date nextPremiumDate;
	@Column(name="POLICYTERM")
	private String policyTerm;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="policy")
	Set<Claims> claims = new HashSet<Claims>();
	
	public Policy(){}

	public Policy(int policyno, double premium, Date issueDate, Date nextPremiumDate,
			String policyTerm) {
		super();
		this.policyno = policyno;
		this.premium = premium;
		this.issueDate = issueDate;
		this.nextPremiumDate = nextPremiumDate;
		this.policyTerm = policyTerm;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Claims> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claims> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "Policy [policyno=" + policyno + ", premium=" + premium
				+ ", issueDate=" + issueDate + ", nextPremiumDate=" + nextPremiumDate + ", policyTerm=" + policyTerm
				+ "]";
	}
	
}
