package com.example.hr.application.business;

import com.example.hr.domain.TcKimlikNo;
import com.example.hr.events.EmployeeEvent;

public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent(TcKimlikNo kimlikNo) {
		super(kimlikNo);
	}

	@Override
	public String toString() {
		return "EmployeeFiredEvent [kimlikNo=" + kimlikNo + "]";
	}

}
