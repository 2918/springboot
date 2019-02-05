package com.springboot.examples.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.examples.service.CustomerService;
import com.springboot.examples.service.PolicyService;
import com.springboot.examples.to.ClaimTO;
import com.springboot.examples.to.CustomerResponse;
import com.springboot.examples.to.CustomerTO;
import com.springboot.examples.to.PolicyResponse;
import com.springboot.examples.to.PolicyTO;

@Controller
@SessionAttributes("claim")
public class PolicyController {

	@Autowired
	PolicyService policyService;
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping(value="/policyForm")
	public String issuePolicyForm() {
		return "policyform";
	}
	
	@PostMapping(value="/issuePolicy", consumes="application/json", produces="application/json")
	@ResponseBody
	public PolicyResponse issuePolicy(@RequestBody @Valid PolicyTO policyTO, BindingResult result){
		
		PolicyResponse response = new PolicyResponse();
		
		if(result.hasErrors()){
			System.out.println("Errors");
			Map<String, String> errors = result.getFieldErrors().stream()
		               .collect(
		                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
		                 );
			response.setValidated(false);
			response.setErrorMessages(errors);
		}
		else{
			System.out.println("Not errros");
			response.setValidated(true);
			boolean insertStatus = policyService.issuePolicy(policyTO);
			if(insertStatus){
				response.setStatusMessage("Policy Issued successfully");
			}
			else{
				response.setStatusMessage("Error while saving policy record");
			}
		}
		System.out.println(policyTO);		
		return response;
	}

	
	@GetMapping(value="/findCustomer", produces="application/json")
	@ResponseBody
	public CustomerResponse findCustomer(@RequestParam int policyNo) {
		CustomerResponse response = new CustomerResponse();
 
		CustomerTO customerTO = customerService.getCustomer(policyNo);
		System.out.println("contnroller" + customerTO);
		if(customerTO == null) {
			response.setValidated(false);
			response.setStatusMessage("PolicyNo-" +policyNo + " doesn't exist");
		}
		else{
			response.setCustomerTO(customerTO);
			response.setValidated(true);
		}
		return response;
	}
	@GetMapping(value="/claimForm")
	public String claimForm(Model model) {
		model.addAttribute("claim", new ClaimTO());
		return "claimform";
	}
	
	
	
	@PostMapping(value="/newClaim")
	public String newClaim(@ModelAttribute(name="claim") @Valid ClaimTO claimTO, BindingResult result, Model model, RedirectAttributes redirect, HttpSession session) {
		

		if(result.hasErrors()) {
			model.addAttribute("claim", claimTO);
			return "claimform";
		}
		else{
			System.out.println(claimTO);
			boolean claimStatus = policyService.newClaim(claimTO);
			if(!claimStatus) {
				model.addAttribute("claimMessage", "Error while making new claim");
				return "claimform";
			}
			//redirect.addFlashAttribute("claim", claimTO);
			model.addAttribute("claim", claimTO);
			
			session.setAttribute("claim", claimTO);
			
			return "redirect:/claimsuccess";	// request forward.	
		}										//redirect
	}

	
	@GetMapping(value="/claimsuccess")
	public String claimsuccess() {
		
		return "claimsuccess";
	}

}
