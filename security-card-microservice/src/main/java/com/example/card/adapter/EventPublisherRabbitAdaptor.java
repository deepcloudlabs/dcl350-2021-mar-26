package com.example.card.adapter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.event.SecurityCardEvent;
import com.example.card.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherRabbitAdaptor implements EventPublisher {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ObjectMapper mapper;

	@Override
	public void publishEvent(SecurityCardEvent event) {
		try {
			var json = mapper.writeValueAsBytes(event);
			rabbitTemplate.convertAndSend("card-exchange", null, json);
		} catch (JsonProcessingException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

}
