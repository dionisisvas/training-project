package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.iri.training.model.UserComment;

public abstract class AddUserComment implements UserCommentRepository{

	@Override
	public UserComment createUserComment(final UserComment userComment) throws SQLException {
		Connection c;
		Statement stmt;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "INSERT INTO USER_COMMENT(commentID,description,commentDate,userID)VALUES(?,?,?,?);";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, userComment.getCommentID());
			pst.setString(2,userComment.getDescription() );
			pst.setString(3,userComment.getDate());
			pst.setInt(4,userComment.getUserID());
			pst.executeUpdate();

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
