package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.iri.training.model.UserComment;
import com.iri.training.model.builder.UserCommentBuilder;

@Repository
public abstract class UserCommentRepositoryImpl implements UserCommentRepository{
	@Override
	public UserComment getUserCommentById(final Long userId) throws SQLException {

		Connection c;
		Statement stmt;
		UserComment userComment = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "SELECT * FROM USER_COMMENT WHERE userID= ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );
			while ( resultSet.next() ) {
				userComment= new UserCommentBuilder().withDescription(resultSet.getString("description")).withDate(resultSet.getString("commentDate"))
					.withCommID(resultSet.getInt("commentID")).withUserID(resultSet.getInt("userID")).build();

			}
			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

			System.exit(0);
		}
		System.out.println("Operation done successfully");

		return userComment;
	}


}
