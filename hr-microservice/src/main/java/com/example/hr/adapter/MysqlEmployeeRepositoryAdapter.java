package com.example.hr.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;
import com.example.hr.repository.EmployeeEntityRepository;
import com.example.hr.repository.EmployeeRepository;

@Repository
public class MysqlEmployeeRepositoryAdapter implements EmployeeRepository {
	@Autowired
	private EmployeeEntityRepository empRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public Employee save(Employee employee) {
		System.err.println(employee);
		var employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
		System.err.println(employeeEntity);
		EmployeeEntity savedEmployee = empRepo.save(employeeEntity);
		return modelMapper.map(savedEmployee, Employee.class);
	}

	@Override
	public boolean exists(TcKimlikNo kimlik) {
		System.err.println("kimlik: "+kimlik);
		return empRepo.existsById(kimlik.getValue());
	}

	@Override
	@Transactional
	public Employee remove(TcKimlikNo kimlik) {
		var empOptional = empRepo.findById(kimlik.getValue());
		if (empOptional.isPresent()) {
			var entity = empOptional.get();
			empRepo.delete(entity);
			return modelMapper.map(entity, Employee.class);
		}
		return null;
	}

}
