package com.iri.training.model;


public class User  {

	private String username;
	private Long userId;
	private String name;
	private String surname;
	private short age;
	private String phoneNo;
	private String address;
	private String password;

	public String getUsername() { return username; }

	public void setUsername(final String username) { this.username = username; }

	public Long getUserId() { return userId; }

	public void setUserId(final Long userId) { this.userId = userId; }

	public String getName() { return name; }

	public void setName(final String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(final String surname) { this.surname = surname; }

	public short getAge() { return age; }

	public void setAge(final short age) { this.age = age; }

	public String getPhoneNo() { return phoneNo; }

	public void setPhoneNo(final String phoneNo) { this.phoneNo = phoneNo; }

	public String getAddress() { return address; }

	public void setAddress(final String address) { this.address = address; }

	private String getPassword() { return password; }

	private void setPassword(final String password) { this.password = password; }
}
