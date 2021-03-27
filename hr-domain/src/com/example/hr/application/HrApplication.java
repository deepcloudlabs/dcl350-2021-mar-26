package com.example.hr.application;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface HrApplication {
	public Employee hireEmployee(Employee employee);
	public Optional<Employee> fireEmployee(TcKimlikNo kimlik);
}
