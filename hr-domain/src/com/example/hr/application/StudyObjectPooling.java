package com.example.hr.application;

public class StudyObjectPooling {

	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=1024
		Integer x = Integer.valueOf(42);
		Integer y = 42;
		Integer u = 549;
		Integer v = 549;
		System.out.println("x==y? "+(x==y));
		System.out.println("u==v? "+(u==v));
		Boolean b = Boolean.valueOf(true);
	}

}
