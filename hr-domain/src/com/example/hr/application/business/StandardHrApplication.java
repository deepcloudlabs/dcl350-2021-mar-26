package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.events.EmployeeHiredEvent;
import com.example.hr.infrastructure.CardPrinter;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;
	private CardPrinter cardPrinter;

	public StandardHrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher,
			CardPrinter cardPrinter) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
		this.cardPrinter = cardPrinter;
	}

	// use case scenario
	@Override
	public Employee hireEmployee(Employee employee) {
		// Business Rule
		var kimlik = employee.getKimlikNo();
		if (employeeRepository.exists(kimlik))
			throw new IllegalArgumentException("Employee already exists.");
		var saveEmployee = employeeRepository.save(employee);
		cardPrinter.printCard(employee);
		eventPublisher.publish(new EmployeeHiredEvent(kimlik, employee.getEmail()));
		return saveEmployee;
	}

	// use case scenario
	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo kimlik) {
		// Business Rule
		if (!employeeRepository.exists(kimlik))
			return Optional.empty();
		var firedEmployee = employeeRepository.remove(kimlik);
		eventPublisher.publish(new EmployeeFiredEvent(kimlik));
		return Optional.of(firedEmployee);
	}

}
