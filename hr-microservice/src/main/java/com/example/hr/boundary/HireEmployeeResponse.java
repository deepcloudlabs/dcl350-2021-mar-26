package com.example.hr.boundary;

public class HireEmployeeResponse {

	private String status;

	public HireEmployeeResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "HireEmployeeResponse [status=" + status + "]";
	}

}
