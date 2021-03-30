package com.example.card.application;

import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;

public interface SecurityCardApplication {
	void printSecurityCard(SecurityCard securityCard);
	void blockSecurityCard(CardId cardId);
}
