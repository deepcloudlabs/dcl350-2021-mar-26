package com.example.card.adapter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.message.PrintSecurityCardMessage;
import com.example.card.service.SecurityCardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SecurityCardApplicationRabbitAdapter {

	@Autowired
	private SecurityCardService securityCardService;
	@Autowired
	private ObjectMapper objectMapper;
	
	@RabbitListener(queues = "card-queue")
	public void listenPrintSecurityCardMessages(String payload) {
		System.err.println("New card print request has been received from rabbitmq: "+payload);
		try {
			var cardMessage = objectMapper.readValue(payload, PrintSecurityCardMessage.class);
			securityCardService.printSecurityCard(cardMessage);
		} catch (JsonProcessingException e) {
			System.err.println("Error: "+e.getMessage());
		}
	}
}
