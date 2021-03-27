package com.example.hr.domain;

// DDD: Entity -> identity, mutable state, business rule, business method, business logic
// Ubiquitous Language: Employee, TcKimlikNo, FullName, Iban, Money, Year, Photo, Department, JobStyle,...
@Entity(identity = "kimlikNo")
public class Employee {
	private TcKimlikNo kimlikNo;
	private FullName fullname;
	private Iban iban;
	private Money salary;
	private Year birthYear;
	private Photo photo;
	private Department department;
	private JobStyle style;
	private Email email;

	public Employee(Builder builder) {
		this.kimlikNo = builder.kimlikNo;
		this.fullname = builder.fullname;
		this.iban = builder.iban;
		this.salary = builder.salary;
		this.birthYear = builder.birthYear;
		this.photo = builder.photo;
		this.department = builder.department;
		this.style = builder.style;
		this.email = builder.email;
	}

	public FullName getFullname() {
		return fullname;
	}

	public void setFullname(FullName fullname) {
		this.fullname = fullname;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobStyle getStyle() {
		return style;
	}

	public void setStyle(JobStyle style) {
		this.style = style;
	}

	public TcKimlikNo getKimlikNo() {
		return kimlikNo;
	}

	public Year getBirthYear() {
		return birthYear;
	}

	// Flow API -> DSL
	public static class Builder {
		private TcKimlikNo kimlikNo;
		private FullName fullname;
		private Iban iban;
		private Money salary;
		private Year birthYear;
		private Photo photo;
		private Department department;
		private JobStyle style;
		public Email email;

		public Builder(TcKimlikNo kimlikNo) {
			this.kimlikNo = kimlikNo;
		}

		public Builder fullname(String firstName, String lastName) {
			this.fullname = FullName.valueOf(firstName, lastName);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.valueOf(value);
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.valueOf(value, currency);
			return this;
		}
		
		public Builder salary(double value) {
			return this.salary(value,FiatCurrency.TL);
		}

		public Builder birthYear(int year) {
			this.birthYear = Year.valueOf(year);
			return this;
		}

		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public Builder jobStyle(JobStyle jobStyle) {
			this.style = jobStyle;
			return this;
		}

		public Builder photo(byte[] data) {
			this.photo = Photo.valueOf(data);
			return this;
		}

		public Builder email(String value) {
			this.email = Email.valueOf(value);
			return this;
		}

		public Employee build() {
			// validation
			// business rule
			return new Employee(this);
		}
	}
}
