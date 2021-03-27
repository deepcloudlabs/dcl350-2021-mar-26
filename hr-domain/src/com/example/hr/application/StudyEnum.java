package com.example.hr.application;

import com.example.hr.domain.FiatCurrency;

@SuppressWarnings("unused")
public class StudyEnum {

	public static void main(String[] args) {
		for (var fc : FiatCurrency.values()) {
			System.out.println(fc.ordinal() + "," + fc.name()+","+fc.code());
		}
		var fc = FiatCurrency.valueOf("USD");

	}

}
