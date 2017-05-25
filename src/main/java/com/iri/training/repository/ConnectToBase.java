package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class ConnectToBase {

	private static Connection c;

	public Connection getConnection() throws SQLException {

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");


		} catch (ClassNotFoundException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}
		System.out.println("Operation done successfully");


		return c;
	}
}



