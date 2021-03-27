package com.example.hr.events;

import com.example.hr.domain.Email;
import com.example.hr.domain.TcKimlikNo;

public class EmployeeHiredEvent extends EmployeeEvent {
	private final Email email;

	public EmployeeHiredEvent(TcKimlikNo kimlikNo, Email email) {
		super(kimlikNo);
		this.email = email;
	}

	public Email getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "EmployeeHiredEvent [email=" + email + ", kimlikNo=" + kimlikNo + "]";
	}

}
