package com.iri.training.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.iri.training.enums.EducationLevel;

public class User {

	private long id;
	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	private String nationality;
	private EducationLevel education;
	private String phoneNo;
	private String address;
	private short age;
	private float height;
	private float weight;

	public long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public String getSurname() {

		return surname;
	}

	public void setSurname(final String surname) {

		this.surname = surname;
	}

	public LocalDate getDateOfBirth() {

		return dateOfBirth;
	}

	public void setDateOfBirth(final LocalDate dateOfBirth) {

		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {

		return placeOfBirth;
	}

	public void setPlaceOfBirth(final String placeOfBirth) {

		this.placeOfBirth = placeOfBirth;
	}

	public String getNationality() {

		return nationality;
	}

	public void setNationality(final String nationality) {

		this.nationality = nationality;
	}

	public EducationLevel getEducation() {

		return education;
	}

	public void setEducation(final EducationLevel education) {

		this.education = education;
	}

	public String getPhoneNo() {

		return phoneNo;
	}

	public void setPhoneNo(final String phoneNo) {

		this.phoneNo = phoneNo;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(final String address) {

		this.address = address;
	}

	public short getAge() {

		return age;
	}

	public void setAge(final short age) {

		this.age = age;
	}

	public float getHeight() {

		return height;
	}

	public void setHeight(final float height) {

		this.height = height;
	}

	public float getWeight() {

		return weight;
	}

	public void setWeight(final float weight) {

		this.weight = weight;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("User{");
		sb.append("id='");
		sb.append(id);
		sb.append('\'');
		sb.append(", name='");
		sb.append(name);
		sb.append('\'');
		sb.append(", surname='");
		sb.append(surname);
		sb.append('\'');
		sb.append(", dateOfBirth='");
		sb.append(dateOfBirth.format(DateTimeFormatter.ISO_LOCAL_DATE));
		sb.append('\'');
		sb.append(", placeOfBirth='");
		sb.append(placeOfBirth);
		sb.append('\'');
		sb.append(", nationality='");
		sb.append(nationality);
		sb.append('\'');
		sb.append(", education='");
		sb.append(education);
		sb.append('\'');
		sb.append(", phoneNo='");
		sb.append(phoneNo);
		sb.append('\'');
		sb.append(", address='");
		sb.append(address);
		sb.append('\'');
		sb.append(", age='");
		sb.append(age);
		sb.append('\'');
		sb.append(", height='");
		sb.append(height);
		sb.append('\'');
		sb.append(", weight='");
		sb.append(weight);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
