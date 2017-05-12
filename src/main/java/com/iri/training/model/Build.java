
package com.iri.training.model;

public class Build {
	private String name;
	private  String surname;
	//private  int id;
	private  String username;
	private  String password;

	public Build(UserBuilder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		//this.id = builder.id;
		this.username = builder.username;
		this.password = builder.password;
	}


	public static String getName(final String name) {
		return name;
	}

	public static String getSurname(final String surname) {
		return surname;
	}
/*
	public int getId() {
		return id;
	}
*/
	public static  String getUsername(final String username) {
		return username;
	}

	public static String getPassword(final String password) {
		return password;
	}

	public static class UserBuilder {
		private static String name;
		private static String surname;
		//private int id;
		private static String username;
		private static String password;

		public static void UserBuilderName(final String name) {
			UserBuilder.name = name;

		}

		public static void UserBuilderSurname(String surname) {
			UserBuilder.surname = surname;

		}
/*
		public void UserBuilderId (int id) {
			this.id = id;

		}
*/
		public static void UserBuilderUsername(String username) {
			UserBuilder.username = username;

		}
		public static void UserBuilderPassword(String password) {
			UserBuilder.password = password;

		}

		public Build build() {
			return new Build(this);
		}

	}
}