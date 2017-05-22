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
public class UserRepositoryImpl  implements UserRepository {

	public User getUserById(Long userId ) throws SQLException {


		Connection c;
		Statement stmt;

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
				int id = resultSet.getInt("usrID");
				final User user= new UserBuilder().withName(resultSet.getString("name")).withSurname(resultSet.getString("surname"))
					.withUsername(resultSet.getString("usrname")).withPassword(resultSet.getString("password")).build();

			}
			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return null;
	}

}
