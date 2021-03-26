package com.example.world.dto;

public class CountryRequest {
	private String code;
	private String name;

	public CountryRequest() {
	}

	public CountryRequest(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
