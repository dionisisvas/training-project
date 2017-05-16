package com.iri.training.model;

public class Build {

	
	private static String Name;
	private static String Surname;
	private static String Username;
	private static String Password;

	public static String getName() {
		return Name;
	}

	public static String getSurname() {
		return Surname;
	}
	public static String getUsername() {
		return Username;
	}
	public static String getPassword() {
		return Password;
	}

	private Build(UserBuilder builder) {
		this.Name=builder.Name;
		this.Surname=builder.Surname;
		this.Username=builder.Username;
		this.Password=builder.Password;

	}

	//Builder Class
	public static class UserBuilder{


		private String Name;
		private String Surname;
		private String Username;
		private String Password;

		public UserBuilder(String name, String surname,String username,String password){
			this.Name=name;
			this.Surname=surname;
			this.Username=username;
			this.Password=password;
		}

		public Build build(){
			return new Build(this);
		}

	}

}