package com.example.card.domain;

import java.util.Objects;
import java.util.UUID;

public class CardId {
	private final String value;

	private CardId(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static CardId of(String value) {
		Objects.requireNonNull(value);
		return new CardId(value);
	}
	
	public static CardId of() {
		return CardId.of(UUID.randomUUID().toString());
	}

	@Override
	public String toString() {
		return "CardId [value=" + value + "]";
	}
		
}
