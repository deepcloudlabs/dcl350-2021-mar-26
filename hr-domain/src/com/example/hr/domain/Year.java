package com.example.hr.domain;

@ValueObject
public class Year {
	private final int value;

	private Year(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Year [value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Year other = (Year) obj;
		if (value != other.value)
			return false;
		return true;
	}

	public int getValue() {
		return value;
	}

	public static Year valueOf(int value) {
		return new Year(value);
	}

}
