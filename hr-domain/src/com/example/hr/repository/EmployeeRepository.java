package com.example.hr.repository;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

public interface EmployeeRepository {

	Employee save(Employee employee);

	boolean exists(TcKimlikNo kimlik);

	Employee remove(TcKimlikNo kimlik);

}
