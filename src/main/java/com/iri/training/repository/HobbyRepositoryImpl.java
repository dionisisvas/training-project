package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.iri.training.model.Hobby;
import com.iri.training.model.builder.HobbyBuilder;

@Repository
public class HobbyRepositoryImpl implements HobbyRepository {
	Logger logger = Logger.getLogger(ImageRepositoryImpl.class);

	@Override
	public Hobby getHobbyById(Long hobbyId) throws SQLException {
		logger.debug("ENTERED getHobbyById for id " + hobbyId);

		Connection c;
		Statement stmt;

		final Hobby hobby;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM hobbies WHERE hobbyId = ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, hobbyId);
			ResultSet resultSet = pst.executeQuery( );
			if(resultSet.next()) {
				hobby = new HobbyBuilder()
					.withHobbyId(resultSet.getLong("hobbyId"))
					.withHobbyName(resultSet.getString("hobbyName"))
					.withDescription(resultSet.getString("description"))
					.build();
			}
			else
			{
				hobby = null;
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}

		logger.debug("EXITING getHobbyById for id " + hobbyId);

		return hobby;
	}

	@Override
	public ArrayList<Long> getUserHobbies(Long userId) throws SQLException {
		logger.debug("ENTERED getUserHobbies");

		final ArrayList<Long> userHobbies = new ArrayList<>();
		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM user_hobbies WHERE userId = ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );

			while(resultSet.next()) {
				userHobbies.add(resultSet.getLong("hobbyId"));
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}

		logger.debug("EXITING getUserHobbies");

		return userHobbies;
	}

	@Override
	public ArrayDeque<Hobby> getHobbyList() throws SQLException {
		logger.debug("ENTERED getHobbyList");

		final ArrayDeque<Hobby> hobbies = new ArrayDeque<>();
		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM hobbies;";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery( );

			while(resultSet.next()) {
				hobbies.add(new HobbyBuilder()
					.withHobbyId(resultSet.getLong("hobbyId"))
					.withHobbyName(resultSet.getString("hobbyName"))
					.withDescription(resultSet.getString("description"))
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

		logger.debug("EXITING getHobbyList");

		return hobbies;
	}
}
