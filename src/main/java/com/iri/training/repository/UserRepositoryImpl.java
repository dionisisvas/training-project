package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.iri.training.model.Build;
import com.iri.training.model.User;

@Repository
public class UserRepositoryImpl extends Build.UserBuilder implements UserRepository {
	public static void main( String args[] ) {


	}
	public User getUserById(Long userId ) throws SQLException {

		Connection c = null;
		Statement stmt = null;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\test.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT * FROM USERS WHERE usrID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				//int id = rs.getInt("usrID");

				Build.UserBuilder.UserBuilderName(rs.getString("name"));
				Build.UserBuilder.UserBuilderSurname(rs.getString("surname"));
				Build.UserBuilder.UserBuilderUsername(rs.getString("usrname"));
				Build.UserBuilder.UserBuilderPassword(rs.getString("password"));

				//System.out.println("ID = " + id);
				//System.out.println("NAME = " + name);
				//System.out.println("surname= " + surname);
				//System.out.println("usrname = " + username);
				//System.out.println("password = " + password);
				//System.out.println();
			}
			rs.close();
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
