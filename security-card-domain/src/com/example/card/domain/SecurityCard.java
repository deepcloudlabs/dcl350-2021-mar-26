package com.example.card.domain;

public class SecurityCard {
	private final CardId cardId;
	private final TcKimlikNo holder;
	private FullName fullname;
	private Photo photo;

	public SecurityCard(CardId cardId, TcKimlikNo holder) {
		this.cardId = cardId;
		this.holder = holder;
	}

	public SecurityCard(Builder builder) {
		this(builder.cardId, builder.holder);
		this.fullname = builder.fullname;
		this.photo = builder.photo;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public CardId getCardId() {
		return cardId;
	}

	public TcKimlikNo getHolder() {
		return holder;
	}

	public static class Builder {
		private CardId cardId;
		private TcKimlikNo holder;
		private FullName fullname;
		private Photo photo;

		public Builder(CardId cardId) {
			this.cardId = cardId;
		}

		public Builder holder(String identity) {
			this.holder = TcKimlikNo.valueOf(identity);
			return this;
		}

		public Builder fullname(String firstName, String lastName) {
			this.fullname = FullName.valueOf(firstName, lastName);
			return this;
		}

		public Builder photo(byte[] data) {
			this.photo = Photo.valueOf(data);
			return this;
		}

		public SecurityCard build() {
			return new SecurityCard(this);
		}
	}
}
