package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;
import com.iri.training.model.builder.UserBuilder;
import com.iri.training.model.User;

@Repository
public  class UserRepositoryImpl implements UserRepository {

	private Connection c;
	private Statement stmt;
	private User user = null;

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");


		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}
		System.out.println("Operation done successfully");


		return c;
	}

	public User getUserById(Long userId ) throws SQLException, ClassNotFoundException {

			c =getConnection();

			stmt = c.createStatement();
			String sql = "SELECT * FROM USERS WHERE usrID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );
			while ( resultSet.next() ) {
				 user = new UserBuilder().withName(resultSet.getString("name")).withSurname(resultSet.getString("surname"))
					.withUsername(resultSet.getString("username")).withPassword(resultSet.getString("password")).withAge(resultSet.getInt("age"))
					 .withPhone(resultSet.getString("phone")).withAddress(resultSet.getString("address")).withUserID(resultSet.getInt("userID"))
					 .build();

			}
			resultSet.close();
			stmt.close();
			c.close();


		return user;
	}
	@Override
	public User createUser(final User user) throws SQLException, ClassNotFoundException {
		    c =getConnection();
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


		return user;
	}
}
