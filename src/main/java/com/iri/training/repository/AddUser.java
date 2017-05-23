package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.iri.training.model.User;

public abstract class AddUser implements UserRepository{
	@Override
	public User createUser(final User user) throws SQLException {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "INSERT INTO USERS(username, userID, name, surname, age, phone, address, password)VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setInt(2,user.getUserID());
			pst.setString(3,user.getName() );
			pst.setString(4,user.getSurname());
			pst.setInt(5,user.getAge());
			pst.setString(6,user.getPhone());
			pst.setString(7,user.getAddress());
			pst.setString(8,user.getPassword());
			pst.executeUpdate();

			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return user;
	}
}
