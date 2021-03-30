package com.example.card.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class SecurityCardDocument {
	@Id
	private String cardId;
	private String holder;
	private String firstName;
	private String lastName;
	private String photo;

	public SecurityCardDocument() {
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "SecurityCardDocument [cardId=" + cardId + ", holder=" + holder + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
