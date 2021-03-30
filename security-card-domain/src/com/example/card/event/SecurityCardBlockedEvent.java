package com.example.card.event;

import com.example.card.domain.CardId;

public class SecurityCardBlockedEvent extends SecurityCardEvent{

	public SecurityCardBlockedEvent(CardId id) {
		super(id);
	}

}
