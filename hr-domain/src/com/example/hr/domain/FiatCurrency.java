package com.example.hr.domain;

@ValueObject
public enum FiatCurrency {
	USD(100), TL(200), EUR(300);
	// private String symbol;
	private int code;

	private FiatCurrency(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}

	public static FiatCurrency valueOf(int code) {
		switch (code) {
		case 100:
			return USD;
		case 200:
			return TL;
		case 300:
			return EUR;
		default:
			throw new IllegalArgumentException("Cannot convert to fiat currency");
		}	
	}
	
}
