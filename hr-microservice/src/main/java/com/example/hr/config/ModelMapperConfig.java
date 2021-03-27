package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;

@Configuration
public class ModelMapperConfig {

	private static final Converter<HireEmployeeRequest,Employee> hireEmployeeRequest2EmployeeConverter = 
			context -> {
				var request = context.getSource();
				return new Employee.Builder(TcKimlikNo.valueOf(request.getIdentity()))
						           .fullname(request.getFirstName(), request.getLastName())
						           .iban(request.getIban())
						           .salary(request.getSalary())
						           .birthYear(request.getBirthYear())
						           .email(request.getEmail())
						           .photo(request.getPhoto().getBytes())
						           .jobStyle(request.getStyle())
						           .department(request.getDepartment())
						           .build();
			} ;
			private static final Converter<EmployeeEntity,Employee> employeeEntity2EmployeeConverter = 
					context -> {
						var employeeEntity = context.getSource();
						return new Employee.Builder(TcKimlikNo.valueOf(employeeEntity.getIdentity()))
								.fullname(employeeEntity.getFirstName(), employeeEntity.getLastName())
								.iban(employeeEntity.getIban())
								.salary(employeeEntity.getSalary())
								.birthYear(employeeEntity.getBirthYear())
								.email(employeeEntity.getEmail())
								.photo(employeeEntity.getPhoto())
								.jobStyle(employeeEntity.getStyle())
								.department(employeeEntity.getDepartment())
								.build();
					} ;
			
    	private static final Converter<Employee,EmployeeEntity> employee2EmployeeEntityConverter = 
    			context -> {
    				var employee = context.getSource();
    				var employeeEntity = new EmployeeEntity();
    				employeeEntity.setIdentity(employee.getKimlikNo().getValue());
    				employeeEntity.setSalary(employee.getSalary().getValue());
    				employeeEntity.setIban(employee.getIban().getValue());
    				employeeEntity.setEmail(employee.getEmail().getValue());
    				employeeEntity.setBirthYear(employee.getBirthYear().getValue());
    				employeeEntity.setDepartment(employee.getDepartment());
    				employeeEntity.setStyle(employee.getStyle());
    				employeeEntity.setPhoto(employee.getPhoto().getData());
    				employeeEntity.setFirstName(employee.getFullname().getFirstName());
    				employeeEntity.setLastName(employee.getFullname().getLastName());
    				return employeeEntity;
    			};	
	@Bean
	public ModelMapper mapper() {
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(hireEmployeeRequest2EmployeeConverter);
		modelMapper.addConverter(employee2EmployeeEntityConverter);
		modelMapper.addConverter(employeeEntity2EmployeeConverter);
		return modelMapper;
	}
}
