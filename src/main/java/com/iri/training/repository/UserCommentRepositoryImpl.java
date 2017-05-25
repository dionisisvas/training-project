package com.iri.training.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.iri.training.model.UserComment;
import com.iri.training.model.builder.UserCommentBuilder;

@Repository
public class UserCommentRepositoryImpl implements UserCommentRepository{
	Logger logger = Logger.getLogger(UserCommentRepositoryImpl.class);

	private Connection c;
	private Statement stmt;
	private UserComment userComment = null;

	ConnectToBase connectToBase;

	@Override
	public UserComment getUserCommentById(final Long userId) throws SQLException {

			logger.debug("ENTERED getUserCommentById" + userComment.toString());
		    c =connectToBase.getConnection();
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

			logger.debug("EXITING createUserComment" + userComment.toString());

		return userComment;
	}

	@Override
	public UserComment createUserComment(final UserComment userComment) throws SQLException {

			logger.debug("ENTERED createUserComment" + userComment.toString());
			c =connectToBase.getConnection();
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

			logger.debug("EXITING createUserComment" + userComment.toString());

		return userComment;
	}
}
