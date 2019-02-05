package com.springboot.examples.to;

import java.util.Map;

public class CustomerResponse {

	private boolean validated;
	private Map<String, String> errorMessages;
	CustomerTO customerTO;
	String statusMessage;
	
	
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	public CustomerTO getCustomerTO() {
		return customerTO;
	}
	public void setCustomerTO(CustomerTO customerTO) {
		this.customerTO = customerTO;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
}
