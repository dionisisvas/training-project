package com.iri.training.model;

public class Account {

	private Long accountId;
	private String username;
	private String password;
	private String email;

	public String getUsername() { return username; }

	public void setUsername(final String username) { this.username = username; }

	public Long getAccountId() { return accountId; }

	public void setAccountId(final Long accountId) { this.accountId = accountId; }

	public String getPassword() { return password; }

	public void setPassword(final String password) { this.password = password; }

	public String getEmail() { return email; }

	public void setEmail(final String email) { this.email = email; }

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Account{");
		sb.append("accountId=");
		sb.append(accountId);
		sb.append('\'');
		sb.append(", username='");
		sb.append(username);
		sb.append('\'');
		sb.append(", email='");
		sb.append(email);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
