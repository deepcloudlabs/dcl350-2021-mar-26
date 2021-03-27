package com.example.hr.events;

import com.example.hr.domain.BusinessEvent;
import com.example.hr.domain.TcKimlikNo;

@BusinessEvent
public abstract class EmployeeEvent {
	protected final TcKimlikNo kimlikNo;

	public EmployeeEvent(TcKimlikNo kimlikNo) {
		this.kimlikNo = kimlikNo;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

}
