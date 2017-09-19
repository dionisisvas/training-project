package com.iri.training.model;

import java.time.LocalDateTime;

public class Account {

	private long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime joinDate;

	public String getUsername() {

		return username;
	}

	public void setUsername(final String username) {

		this.username = username;
	}

	public long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public LocalDateTime getJoinDate() {

		return joinDate;
	}

	public void setJoinDate(final LocalDateTime joinDate) {

		this.joinDate = joinDate;
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Account{");
		sb.append("id=");
		sb.append(id);
		sb.append('\'');
		sb.append(", username='");
		sb.append(username);
		sb.append('\'');
		sb.append(", email='");
		sb.append(email);
		sb.append('\'');
		sb.append(", joinDate='");
		sb.append(joinDate);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
