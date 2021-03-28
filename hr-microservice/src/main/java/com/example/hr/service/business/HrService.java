package com.example.hr.service.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.boundary.FireEmployeeResponse;
import com.example.hr.boundary.HireEmployeeRequest;
import com.example.hr.boundary.HireEmployeeResponse;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Service
public class HrService {
	@Autowired
	private HrApplication hrApplication;
	@Autowired
	private ModelMapper modelMapper;
	
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		var employee = modelMapper.map(request, Employee.class);
		System.err.println(employee);
		hrApplication.hireEmployee(employee);
		return new HireEmployeeResponse("success");
	}

	public FireEmployeeResponse fireEmployee(String identity) {
		var firedEmployee = hrApplication.fireEmployee(TcKimlikNo.valueOf(identity));
		if (firedEmployee.isEmpty())
		  return new FireEmployeeResponse("failed");
		return new FireEmployeeResponse("success");
	}

}
