
package com.iri.training.model;

public class Factory {
	private final String name; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	private Factory(UserBuilder builder) {
		this.name = builder.name;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public static class UserBuilder {
		private final String name;
		private final String lastName;
		private int age;
		private String phone;
		private String address;

		public UserBuilder(String name, String lastName) {
			this.name = name;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public Factory build() {
			return new Factory(this);
		}

	}
}