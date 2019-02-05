package com.springboot.examples.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.examples.model.Claims;
import com.springboot.examples.model.Customer;
import com.springboot.examples.model.Policy;
import com.springboot.examples.repository.CustomerRepository;
import com.springboot.examples.repository.PolicyRepository;
import com.springboot.examples.to.ClaimTO;
import com.springboot.examples.to.PolicyTO;

@Service
public class PolicyService {

	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Policy getPolicy(PolicyTO policyTO){
		
		Policy policy = new Policy(policyTO.getPolicyno(), policyTO.getPremium(), policyTO.getIssueDate(), policyTO.getNextPremiumDate(), policyTO.getPolicyTerm());
		return policy;
	}
	public PolicyTO getPolicyTO(Policy policy){
		
		PolicyTO policyTO = new PolicyTO(policy.getPolicyno(), policy.getPremium(), policy.getIssueDate(), policy.getNextPremiumDate(), policy.getPolicyTerm(), policy.getCustomer().getCustomerId());
		return policyTO;
	}
	
	public Claims getClaim(ClaimTO claimTO){
		return new Claims(claimTO.getClaimAmount(), claimTO.getClaimDate());
	}
	
	
	public boolean issuePolicy(PolicyTO policyTO) {
		try{
			Optional<Customer> cust = customerRepository.findById(policyTO.getCustomerId());
			if(cust.isPresent()){
				Policy policy = getPolicy(policyTO);
				policy.setCustomer(cust.get());
				policyRepository.save(policy);
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
			
		}
	}
	
	public boolean newClaim(ClaimTO claimTO) {
		Optional<Policy> optionalPolicy = policyRepository.findById(claimTO.getPolicyNo());
		if(optionalPolicy.isPresent()) {
			Policy policy = optionalPolicy.get();			
			Claims claims = getClaim(claimTO);
			policy.getClaims().add(claims);
			claims.setPolicy(policy);
			
			policyRepository.save(policy);
			return true;
		}
		else{
			return false;
		}
		
		//policyRepository.findTop10ByPremium(premium)
		//policyRepository.findPolicyWithClaims();
		
	}
}

