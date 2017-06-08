package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
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
	ConnectToBase connectToBase=new ConnectToBase();
	private DataSource dataSource=connectToBase.getDataSource();
	private JdbcTemplate jdbcTemplate;

	public UserCommentRepositoryImpl() throws IOException {}

	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	FileInputStream fis = new FileInputStream("File/app_sql.properties");
	java.util.PropertyResourceBundle propety = new java.util.PropertyResourceBundle(fis);

	Logger logger = Logger.getLogger(UserCommentRepositoryImpl.class);


	@Override
	public UserComment getCommentsByUserId(final Long userId) throws SQLException {

			logger.debug("ENTERED getUserCommentById: " + userId);

			String sql=propety.getString("SELECT_COMMENT");
		    jdbcTemplate=new JdbcTemplate(dataSource);
			UserComment userComment=jdbcTemplate.queryForObject(sql,new Object[]{userId},new UserCommentMapper());
		    logger.debug("EXITING getCommentsByUserId: " + userComment);
		    return userComment;

	}

	@Override
	public UserComment createUserComment(final UserComment userComment) throws SQLException {

			logger.debug("ENTERED createUserComment: " + userComment);
			String sql=propety.getString("CREATE_COMMENT");
		    jdbcTemplate=new JdbcTemplate(dataSource);
		    jdbcTemplate.update(sql,userComment.getCommentID(),userComment.getDescription(),userComment.getDate(),userComment.getUserID());
			System.out.print("UserComment Inserted Successfully");

			logger.debug("EXITING createUserComment: " + userComment);

		return userComment;
	}
	private static final class UserCommentMapper implements RowMapper<UserComment> {

		@Override
		public UserComment mapRow(final ResultSet resultSet, final int i) throws SQLException {


			UserComment userComment = new UserCommentBuilder().withDescription(resultSet.getString("description")).withDate(resultSet.getString("commentDate"))
					.withCommID(resultSet.getInt("commentID")).withUserID(resultSet.getInt("userID")).build();


				return userComment;
			}

	}
}
