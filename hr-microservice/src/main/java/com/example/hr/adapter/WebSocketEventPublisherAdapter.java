package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;

@Service
@ConditionalOnProperty(value="messaging.system", havingValue = "websocket")
public class WebSocketEventPublisherAdapter implements EventPublisher {
	@Autowired
	private SimpMessagingTemplate msgTemplate;
	
	@Override
	public void publish(EmployeeEvent employeeEvent) {
		msgTemplate.convertAndSend("/topic/events", employeeEvent);

	}

}
