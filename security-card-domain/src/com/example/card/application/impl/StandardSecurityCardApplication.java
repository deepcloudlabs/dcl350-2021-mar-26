package com.example.card.application.impl;

import com.example.card.application.SecurityCardApplication;
import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;
import com.example.card.event.SecurityCardBlockedEvent;
import com.example.card.infrastructure.EventPublisher;
import com.example.card.infrastructure.SecurityCardPrinterService;
import com.example.card.repository.SecurityCardRepository;

public class StandardSecurityCardApplication implements SecurityCardApplication {
	private SecurityCardPrinterService securityCardPrinterService;
	private SecurityCardRepository securityCardRepository;
	private EventPublisher eventPublisher;
	
	public StandardSecurityCardApplication(SecurityCardPrinterService securityCardPrinterService,
			SecurityCardRepository securityCardRepository, EventPublisher eventPublisher) {
		this.securityCardPrinterService = securityCardPrinterService;
		this.securityCardRepository = securityCardRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void printSecurityCard(SecurityCard securityCard) {
		securityCardPrinterService.printCard(securityCard);
		securityCardRepository.save(securityCard);
	}

	@Override
	public void blockSecurityCard(CardId cardId) {
		if (!securityCardRepository.exists(cardId)) {
			throw new IllegalArgumentException("Cannot find the security card");
		}
		securityCardRepository.removeByCardId(cardId);
		eventPublisher.publishEvent(new SecurityCardBlockedEvent(cardId));
	}

}
