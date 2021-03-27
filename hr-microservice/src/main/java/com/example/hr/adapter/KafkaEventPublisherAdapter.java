package com.example.hr.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.events.EmployeeEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@ConditionalOnProperty(value = "messaging.system", havingValue = "kafka")
public class KafkaEventPublisherAdapter implements EventPublisher {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper mapper;

	@Override
	public void publish(EmployeeEvent employeeEvent) {
		try {
			var json = mapper.writeValueAsString(employeeEvent);
			kafkaTemplate.send("hr", json);
		} catch (JsonProcessingException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
