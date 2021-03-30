package com.example.card.message;

public class PrintSecurityCardMessage {
	private String cardId;
	private String identityNo;
	private String firstName;
	private String lastName;
	private String photo;

	public PrintSecurityCardMessage() {
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
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
		return "PrintSecurityCardMessage [cardId=" + cardId + ", identityNo=" + identityNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

}
