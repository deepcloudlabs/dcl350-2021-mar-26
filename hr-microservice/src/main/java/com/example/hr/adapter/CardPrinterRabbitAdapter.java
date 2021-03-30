package com.example.hr.adapter;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.boundary.PrintSecurityCardMessage;
import com.example.hr.domain.Employee;
import com.example.hr.infrastructure.CardPrinter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CardPrinterRabbitAdapter implements CardPrinter {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void printCard(Employee employee) {
		var printSecurityCardMessage = modelMapper.map(employee, PrintSecurityCardMessage.class);
		try {
			var json = objectMapper.writeValueAsString(printSecurityCardMessage);
			rabbitTemplate.convertAndSend("card-exchange", null, json);
		} catch (JsonProcessingException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

}
