package com.example.hr.application;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.JobStyle;
import com.example.hr.domain.TcKimlikNo;

@SuppressWarnings("unused")
public class StudyBuilder {

	public static void main(String[] args) {
		// DSL
		Employee emp = new Employee.Builder(TcKimlikNo.valueOf("1111111111"))
				                   .fullname("jack", "bauer")
				                   .department(Department.FINANCE)
				                   .birthYear(1956)
				                   .email("jack@example.com")
				                   .jobStyle(JobStyle.FULL_TIME)
				                   .build();

	}

}
