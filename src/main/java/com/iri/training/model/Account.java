package com.iri.training.model;

public class Account {

	private Long userId;
	private String username;
	private String password;

	public String getUsername() { return username; }

	public void setUsername(final String username) { this.username = username; }

	public Long getUserId() { return userId; }

	public void setUserId(final Long userId) { this.userId = userId; }

	public String getPassword() { return password; }

	public void setPassword(final String password) { this.password = password; }

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Account{");
		sb.append(", userId=");
		sb.append(userId);
		sb.append('\'');
		sb.append("username='");
		sb.append(username);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
