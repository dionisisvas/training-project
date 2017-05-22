package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;

import org.springframework.stereotype.Repository;

import com.iri.training.model.UserBuilder;
import com.iri.training.model.User;

@Repository
public class UserRepositoryImpl  implements UserRepository {

	public User getUserById(Long userId ) throws SQLException {
		final User user;
		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM users WHERE userID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );

			user = new UserBuilder().withUsername(resultSet.getString("username"))
									.withUserId(resultSet.getLong("userId"))
									.withName(resultSet.getString("name"))
									.withSurname(resultSet.getString("surname"))
									.withAge(resultSet.getShort("age"))
									.withPhoneNo(resultSet.getString("phoneNo"))
									.withAddress(resultSet.getString("address"))
									.build();

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}

		return user;
	}

	public ArrayDeque<User> getUserArray() throws SQLException {
		final ArrayDeque<User> usersArrayDeque = new ArrayDeque<>();
		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT username, userId, name, surname, age FROM users;";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery( );

			while(resultSet.next()) {
				usersArrayDeque.add(new UserBuilder().withUsername(resultSet.getString("username"))
					.withUserId(resultSet.getLong("userId"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withAge(resultSet.getShort("age"))
					.build());
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}

		return usersArrayDeque;
	}
}
