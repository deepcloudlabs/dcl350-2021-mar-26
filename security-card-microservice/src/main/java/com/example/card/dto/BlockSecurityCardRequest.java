package com.example.card.dto;

public class BlockSecurityCardRequest {
	private String cardId;
	private String identity;
	private String firstName;
	private String lastName;
	private String photo;

	public BlockSecurityCardRequest() {
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
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
		return "BlockSecurityCardRequest [cardId=" + cardId + ", identity=" + identity + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
