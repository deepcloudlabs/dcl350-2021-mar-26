package com.example.card.adapter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.card.message.PrintSecurityCardMessage;
import com.example.card.service.SecurityCardService;

@Service
public class SecurityCardApplicationRabbitAdapter {

	@Autowired
	private SecurityCardService securityCardService;
	
	@RabbitListener(queues = "???")
	public void listenPrintSecurityCardMessages(PrintSecurityCardMessage message) {
		securityCardService.printSecurityCard(message);
	}
}
