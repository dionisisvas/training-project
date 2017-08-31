package com.iri.training.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.model.CommentReply;
import com.iri.training.model.builder.CommentReplyBuilder;

@Repository
public class CommentReplyRepositoryImpl implements CommentReplyRepository {

	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private InputStream resourceAsStream = CommentReplyRepositoryImpl.class.getResourceAsStream("/sql_queries.properties");
	private PropertyResourceBundle property = new PropertyResourceBundle(resourceAsStream);


	public CommentReplyRepositoryImpl() throws IOException {}

	@Override public CommentReply getReplyById(final long replyId) throws SQLException {

		logger.debug("ENTERED getReplyById for replyId: " + replyId);

		final CommentReply reply;
		final String sql = property.getString("GET_COMMENT_REPLY_BY_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		reply = jdbcTemplate.query(sql, new Object[]{replyId}, new ReplyResultSetExtractor());

		logger.debug("EXITING getReplyById for replyId: " + replyId);

		return reply;
	}

	public List<CommentReply> getCommentReplies(final long parentId) throws SQLException {

		logger.debug("ENTERED getCommentReplies for parentId: " + parentId);

		final List<CommentReply> replies;
		final String sql = property.getString("GET_COMMENT_REPLIES");
		jdbcTemplate = new JdbcTemplate(dataSource);
		replies = new ArrayList<CommentReply>(
						jdbcTemplate.query(sql,
								new Object[]{parentId},
								new CommentRepliesResultSetExtractor()));

		logger.debug("EXITING getCommentReplies for parentId: " + parentId);

		return replies;
	}

	private static final class ReplyResultSetExtractor implements ResultSetExtractor<CommentReply> {

		@Override
		public CommentReply extractData(final ResultSet resultSet) throws SQLException {

			final CommentReply reply;

			if (resultSet.next()) {
				reply = new CommentReplyBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withParentId(resultSet.getLong("parent_id"))
					.withContent(resultSet.getString("content"))
					.withCreationDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("creation_date"),
						0, ZoneOffset.UTC))
					.withLastEditDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("last_edit_date"),
						0, ZoneOffset.UTC))
					.build();
			}
			else
			{
				return null;
			}

			return reply;
		}
	}

	private static final class CommentRepliesResultSetExtractor implements ResultSetExtractor<List<CommentReply>> {

		@Override
		public List<CommentReply> extractData(final ResultSet resultSet) throws SQLException {

			final List<CommentReply> replies = new ArrayList<>();
			while (resultSet.next()) {
				replies.add(new CommentReplyBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withContent(resultSet.getString("content"))
					.withCreationDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("creation_date"),
						0, ZoneOffset.UTC))
					.withLastEditDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("last_edit_date"),
						0, ZoneOffset.UTC))
					.build());
			}

			return replies;
		}
	}
}
