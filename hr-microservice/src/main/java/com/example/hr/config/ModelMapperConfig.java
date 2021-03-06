package com.example.hr.config;

import java.util.UUID;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.PrintSecurityCardMessage;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;

@Configuration
public class ModelMapperConfig {

	private static final Converter<HireEmployeeRequest,Employee> hireEmployeeRequest2EmployeeConverter = 
			context -> {
				var request = context.getSource();
				System.err.println(request);
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
		
		private static final Converter<Employee,PrintSecurityCardMessage> employee2PrintSecurityCardMessage = 
				context -> {
					var employee = context.getSource();
					var printSecurityCardMessage = new PrintSecurityCardMessage();
					printSecurityCardMessage.setCardId(UUID.randomUUID().toString());
					printSecurityCardMessage.setIdentityNo(employee.getKimlikNo().getValue());
					printSecurityCardMessage.setPhoto(new String(employee.getPhoto().getData()));
					printSecurityCardMessage.setFirstName(employee.getFullname().getFirstName());
					printSecurityCardMessage.setLastName(employee.getFullname().getLastName());
					return printSecurityCardMessage;
				};	
	@Bean
	public ModelMapper mapper() {
		System.err.println("mapper");
		var modelMapper = new ModelMapper();
		modelMapper.addConverter(hireEmployeeRequest2EmployeeConverter,HireEmployeeRequest.class,Employee.class);
		modelMapper.addConverter(employee2EmployeeEntityConverter,Employee.class,EmployeeEntity.class);
		modelMapper.addConverter(employeeEntity2EmployeeConverter,EmployeeEntity.class,Employee.class);
		modelMapper.addConverter(employee2PrintSecurityCardMessage,Employee.class,PrintSecurityCardMessage.class);
		return modelMapper;
	}
}
