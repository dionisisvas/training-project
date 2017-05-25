package com.iri.training.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.iri.training.model.User;
import com.iri.training.model.builder.UserBuilder;

@Repository
public  class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	private Connection c;
	private Statement stmt;
	private User user = null;
	 ConnectToBase connectToBase;
	public User getUserById(Long userId ) throws SQLException {

			logger.debug("ENTERED getUserById" + user.toString());

			c =connectToBase.getConnection();

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

			logger.debug("EXITING getUserById " + user.toString());

			return user;
	}
	@Override
	public User createUser(final User user) throws SQLException {
		logger.debug("ENTERED createUser" + user.toString());


			c =connectToBase.getConnection();
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

		logger.debug("EXITING createUser " + user.toString());
		return user;
	}

}
