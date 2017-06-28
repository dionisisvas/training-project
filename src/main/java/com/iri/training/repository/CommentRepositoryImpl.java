package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.model.UserComment;
import com.iri.training.model.builder.UserCommentBuilder;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	Logger logger = Logger.getLogger(CommentRepositoryImpl.class);
	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private FileInputStream fis = new FileInputStream("src/main/resources/sql_queries.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(fis);


	public CommentRepositoryImpl() throws IOException {}


	@Override
	public List<UserComment> getCommentsByUserId(final Long userId) throws SQLException {

		logger.debug("ENTERED getUserCommentById for userId: " + userId);

		String sql=property.getString("SELECT_COMMENT");
		jdbcTemplate=new JdbcTemplate(dataSource);
		final List<UserComment> userComment=jdbcTemplate.query(sql,new Object[]{userId},new UserCommentMapper());

		logger.debug("EXITING getCommentsByUserId: " + userComment);
		return userComment;

	}

	@Override
	public UserComment createUserComment(final UserComment userComment) throws SQLException {

		logger.debug("ENTERED createUserComment for comment: " + userComment);

		String sql=property.getString("CREATE_COMMENT");
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,userComment.getCommentID(),userComment.getDescription(),userComment.getDate(),userComment.getUserID());

		logger.debug("EXITING createUserComment: " + userComment);

		return userComment;
	}
	private static final class UserCommentMapper implements ResultSetExtractor<List<UserComment>> {

		@Override
		public List<UserComment> extractData(final ResultSet resultSet) throws SQLException {

			final List<UserComment> userComment = new ArrayList<>();

			while(resultSet.next()) {
				userComment.add(new UserCommentBuilder()
					.withDescription(resultSet.getString("description"))
					.withDate(resultSet.getString("commentDate"))
					.withCommID(resultSet.getInt("commentID"))
					.withUserID(resultSet.getInt("userID"))
					.build());
			}


			return userComment;
		}
	}
}
