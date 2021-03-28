package com.example.hr.boundary;

public class RestErrorMessage {
	private String reason;

	public RestErrorMessage(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {
		return "RestErrorMessage [reason=" + reason + "]";
	}
	
}
