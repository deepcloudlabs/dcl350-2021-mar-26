package com.example.card.dto;

public class CardInfo {
	private String id;
	private String firstName;
	private String lastName;
	private byte[] photo;

	public CardInfo() {
	}

	public CardInfo(String id, String firstName, String lastName, byte[] photo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CardInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
