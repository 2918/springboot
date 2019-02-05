package com.springboot.examples.to;

import java.util.Map;

public class PolicyResponse {

	private boolean validated;
	private Map<String, String> errorMessages;
	PolicyTO policyTO;
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
	public PolicyTO getPolicyTO() {
		return policyTO;
	}
	public void setPolicyTO(PolicyTO policyTO) {
		this.policyTO = policyTO;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
