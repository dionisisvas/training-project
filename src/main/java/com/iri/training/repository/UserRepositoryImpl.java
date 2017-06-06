package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.iri.training.model.builder.UserBuilder;
import com.iri.training.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	
	public User getUserById(Long userId ) throws SQLException {
		logger.debug("ENTERED getUserById for id " + userId);
		
		Connection c;
		Statement stmt;
						
		final User user;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM users WHERE userId = ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );

			if(resultSet.next()) {
				user = new UserBuilder()
					.withUsername(resultSet.getString("username"))
					.withUserId(resultSet.getLong("userId"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withAge(resultSet.getShort("age"))
					.withPhoneNo(resultSet.getString("phoneNo"))
					.withAddress(resultSet.getString("address"))
					.build();
			}
			else
			{
				user = null;
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
		
		logger.debug("EXITING getUserById for user " + user.toString());
		
		return user;
	}

	public ArrayDeque<User> getUserArray() throws SQLException {
		logger.debug("ENTERED getUserArray");

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
				usersArrayDeque.add(new UserBuilder()
					.withUsername(resultSet.getString("username"))
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
		
		logger.debug("EXITING getUserArray");
		
		return usersArrayDeque;
	}
	
	@Override
	public User createUser(final User user) throws SQLException {

		logger.debug("ENTERED createUser");

		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO users(username, userId, name, surname, age, phoneNo, address, password) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setLong(2, user.getUserId());
			pst.setString(3, user.getName());
			pst.setString(4, user.getSurname());
			pst.setShort(5, user.getAge());
			pst.setString(6, user.getPhoneNo());
			pst.setString(7, user.getAddress());
			pst.setString(8, null);
			pst.executeUpdate();

			stmt.close();
			c.close();

			logger.debug("EXITING createUser");
			return user;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
	}
}
