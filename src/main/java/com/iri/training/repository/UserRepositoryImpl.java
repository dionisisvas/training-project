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
public abstract class UserRepositoryImpl implements UserRepository {

	public User getUserById(Long userId ) throws SQLException {


		Connection c;
		Statement stmt;
        User user = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\test.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT * FROM USERS WHERE usrID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );
			while ( resultSet.next() ) {
				 user= new UserBuilder().withName(resultSet.getString("name")).withSurname(resultSet.getString("surname"))
					.withUsername(resultSet.getString("username")).withPassword(resultSet.getString("password")).withAge(resultSet.getInt("age"))
					 .withPhone(resultSet.getString("phone")).withAddress(resultSet.getString("address")).withUserID(resultSet.getInt("userID"))
					 .build();

			}
			resultSet.close();
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
