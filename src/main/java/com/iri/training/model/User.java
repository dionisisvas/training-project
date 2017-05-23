package com.iri.training.model;


public class User  {


	private String name;
	private String surname;
	private String username;
	private String password;


	public String getName(final String name) {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname(final String surname) {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getUsername(final String username) {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword(final String password) {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("user name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", username=");
		builder.append(username);
		builder.append(",password");
		builder.append(password);


		return builder.toString();
	}

}
