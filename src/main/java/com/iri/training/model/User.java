package com.iri.training.model;

import java.time.LocalDate;

public class User  {

	private Long userId;
	private String name;
	private String surname;
	private short age;
	private LocalDate dateOfBirth;
	private String phoneNo;
	private String address;

	public Long getUserId() { return userId; }

	public void setUserId(final Long userId) { this.userId = userId; }

	public String getName() { return name; }

	public void setName(final String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(final String surname) { this.surname = surname; }

	public short getAge() { return age; }

	public void setAge(final short age) { this.age = age; }

	public LocalDate getDateOfBirth() { return dateOfBirth; }

	public void setDateOfBirth(final LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth; }

	public String getPhoneNo() { return phoneNo; }

	public void setPhoneNo(final String phoneNo) { this.phoneNo = phoneNo; }

	public String getAddress() { return address; }

	public void setAddress(final String address) { this.address = address; }

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("User{");
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name='");
		sb.append(name);
		sb.append('\'');
		sb.append(", surname='");
		sb.append(surname);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}

}
