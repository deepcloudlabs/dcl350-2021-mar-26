package com.example.hr.domain;

import java.util.Objects;

@ValueObject
public class Email {
	private final String value;

	private Email(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Email valueOf(String value) {
		Objects.requireNonNull(value);
		if (!value.matches("^.*@.*"))
			throw new IllegalArgumentException("This is not a valid email.");
		return new Email(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Email [value=" + value + "]";
	}

}
