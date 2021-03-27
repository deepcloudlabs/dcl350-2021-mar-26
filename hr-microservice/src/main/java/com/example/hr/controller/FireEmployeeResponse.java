package com.example.hr.controller;

public class FireEmployeeResponse {

	private final String status;

	public FireEmployeeResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "FireEmployeeResponse [status=" + status + "]";
	}

}
