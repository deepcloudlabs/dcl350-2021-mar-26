package com.example.card.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.card.application.SecurityCardApplication;
import com.example.card.application.impl.StandardSecurityCardApplication;
import com.example.card.infrastructure.EventPublisher;
import com.example.card.infrastructure.SecurityCardPrinterService;
import com.example.card.repository.SecurityCardRepository;

@Configuration
public class AppConfig {
	@Bean
	public SecurityCardApplication app(SecurityCardPrinterService securityCardPrinterService,
			SecurityCardRepository securityCardRepository, EventPublisher eventPublisher) {
		return new StandardSecurityCardApplication(securityCardPrinterService, securityCardRepository, eventPublisher);
	}
}
