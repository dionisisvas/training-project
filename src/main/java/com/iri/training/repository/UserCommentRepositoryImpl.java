package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iri.training.model.UserComment;
import com.iri.training.model.builder.UserCommentBuilder;

@Repository
public class UserCommentRepositoryImpl implements UserCommentRepository{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
	}

	Logger logger = Logger.getLogger(UserCommentRepositoryImpl.class);

	private UserComment userComment = null;


	@Override
	public UserComment getUserCommentById(final Long userId) throws SQLException {

			logger.debug("ENTERED getUserCommentById" + userComment.toString());

			String sql="SELECT * FROM USER_COMMENT WHERE userID= ?;";
		    jdbcTemplate=new JdbcTemplate(dataSource);
			userComment=jdbcTemplate.queryForObject(sql,new Object[]{userId},new UserCommentMapper());

		return userComment;

	}

	@Override
	public UserComment createUserComment(final UserComment userComment) throws SQLException {

			logger.debug("ENTERED createUserComment" + userComment.toString());
			String sql = "INSERT INTO USER_COMMENT(commentID,description,commentDate,userID)VALUES(?,?,?,?);";
		    jdbcTemplate=new JdbcTemplate(dataSource);
		    jdbcTemplate.update(sql,userComment.getCommentID(),userComment.getDescription(),userComment.getDate(),userComment.getUserID());
			System.out.print("UserComment Inserted Successfully");

			logger.debug("EXITING createUserComment" + userComment.toString());

		return null;
	}
	private static final class UserCommentMapper implements RowMapper<UserComment> {
		UserComment userComment;
		@Override public UserComment mapRow(final ResultSet resultSet, final int i) throws SQLException {

			userComment= new UserCommentBuilder().withDescription(resultSet.getString("description")).withDate(resultSet.getString("commentDate"))
					.withCommID(resultSet.getInt("commentID")).withUserID(resultSet.getInt("userID")).build();
			return userComment;
		}
	}
}
