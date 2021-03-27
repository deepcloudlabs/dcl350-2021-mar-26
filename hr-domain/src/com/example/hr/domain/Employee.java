package com.example.hr.domain;

// DDD: Entity -> identity, mutable state, business rule, business method, business logic
// Ubiquitous Language: Employee, TcKimlikNo, FullName, Iban, Money, Year, Photo, Department, JobStyle,...
@Entity(identity="kimlikNo")
public class Employee {
	private TcKimlikNo kimlikNo;
	private FullName fullname;
	private Iban iban;
	private Money salary;
	private Year birthYear;
	private Photo photo;
	private Department department;
	private JobStyle style;
}
