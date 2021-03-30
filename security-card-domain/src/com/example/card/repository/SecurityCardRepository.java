package com.example.card.repository;

import com.example.card.domain.CardId;
import com.example.card.domain.SecurityCard;

public interface SecurityCardRepository {

	void save(SecurityCard securityCard);

	boolean exists(CardId cardId);

	SecurityCard removeByCardId(CardId cardId);

}
