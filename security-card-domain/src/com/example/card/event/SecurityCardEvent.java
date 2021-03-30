package com.example.card.event;

import com.example.card.domain.CardId;

public abstract class SecurityCardEvent {
	protected final CardId id;

	public SecurityCardEvent(CardId id) {
		this.id = id;
	}

	public CardId getId() {
		return id;
	}
	
}
