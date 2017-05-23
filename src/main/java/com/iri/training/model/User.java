package com.iri.training.model;


public class User  {


	private String name;
	private String surname;
	private String username;
	private String password;
	private String address;
	private String phone;
	private int userID;
	private int age;


	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(final int userID) {
		this.userID = userID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("name=");
		builder.append(name);
		builder.append("surname=");
		builder.append(surname);
		builder.append("username=");
		builder.append(username);
		builder.append("password");
		builder.append(password);
		builder.append("address");
		builder.append(address);
		builder.append("phone");
		builder.append(phone);
		builder.append("userID");
		builder.append(userID);
		builder.append("age");
		builder.append(age);


		return builder.toString();
	}

}
