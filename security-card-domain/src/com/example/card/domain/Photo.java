package com.example.card.domain;

import java.util.Objects;

public class Photo {
	private final byte[] data;

	private Photo(byte[] data) {
		this.data = data;
	}

	public byte[] getData() {
		return data;
	}

	public static Photo valueOf(byte[] data) {
		Objects.requireNonNull(data);
		return new Photo(data);
	}
}
