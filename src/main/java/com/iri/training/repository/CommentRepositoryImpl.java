package com.iri.training.repository;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.builder.CommentBuilder;

@Repository
public final class CommentRepositoryImpl implements CommentRepository {

	private static final Logger logger = Logger.getLogger(CommentRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection.getDataSource();
	private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	@Override
	public final Comment getCommentById(final long commentId) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId);

		final Comment comment;

		comment = jdbcTemplate.query(PropertiesConfig.GET_COMMENT_BY_ID,
			new Object[]{commentId},
			new CommentResultSetExtractor());

		logger.debug("EXITING getCommentById with comment: " + comment);

		return comment;
	}

	@Override
	public final List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId);

		final List<Comment> comments;

		comments = new ArrayList<Comment>(
						jdbcTemplate.query(PropertiesConfig.GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID,
								new Object[]{subjectType.name(), subjectId},
								new CommentsBySubjectResultSetExtractor()));

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId);

		return comments;
	}

	@Override
	public final long addCommentAndGetGeneratedId(final Comment comment) throws SQLException {

		logger.debug("ENTERED addCommentAndGetGeneratedId for comment: " + comment);

		final KeyHolder kh = new GeneratedKeyHolder();
		final long commentId;

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override public PreparedStatement createPreparedStatement(final Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(PropertiesConfig.ADD_COMMENT,
						Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, comment.getPosterId());
				ps.setString(2, comment.getSubjectType().name());
				ps.setLong(3, comment.getSubjectId());
				ps.setString(4, comment.getContent());
				ps.setLong(5, Instant.now().getEpochSecond()); // creation_date

				return ps;
			}
		}, kh);

		commentId = kh.getKey().longValue();

		logger.debug("EXITING addCommentAndGetGeneratedId for comment: " + comment);

		return commentId;
	}

	@Override
	public final void deleteComment(final long commentId) throws SQLException {

		logger.debug("ENTERED deleteComment for commentId: " + commentId);

		jdbcTemplate.update(PropertiesConfig.DELETE_COMMENT, commentId);

		logger.debug("EXITING deleteComment for commentId: " + commentId);
	}

	@Override
	public final void deleteCommentReplies(final SubjectType subjectType, final long parentId) throws SQLException {

		logger.debug("ENTERED deleteCommentReplies for postId: " + parentId);

		jdbcTemplate.update(PropertiesConfig.DELETE_COMMENT_REPLIES, subjectType, parentId);

		logger.debug("EXITING deleteCommentReplies for postId: " + parentId);
	}

	@Override
	public final void editComment(final Comment comment) throws SQLException {

		logger.debug("ENTERED editComment for comment: " + comment);

		jdbcTemplate.update(PropertiesConfig.EDIT_COMMENT,
			comment.getContent(),
			Instant.now().getEpochSecond(),
			comment.getId());

		logger.debug("EXITING editComment for comment: " + comment);
	}

	private static final class CommentResultSetExtractor implements ResultSetExtractor<Comment> {

		@Override
		public Comment extractData(final ResultSet resultSet) throws SQLException {

			final Comment comment;

			if (resultSet.next()) {
				comment = new CommentBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withSubjectType(SubjectType.valueOf(
						resultSet.getString("subject_type")))
					.withSubjectId(resultSet.getLong("subject_id"))
					.withContent(resultSet.getString("content"))
					.withCreationDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("creation_date"),
						0, ZoneOffset.UTC))
					.withLastEditDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("last_edit_date"),
						0, ZoneOffset.UTC))
					.build();
			}
			else {
				return null;
			}

			return comment;
		}
	}

	private static final class CommentsBySubjectResultSetExtractor implements ResultSetExtractor<List<Comment>> {

		@Override
		public List<Comment> extractData(final ResultSet resultSet) throws SQLException {

			final List<Comment> comments = new ArrayList<>();

			while (resultSet.next()) {
				comments.add(new CommentBuilder()
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

			return comments;
		}
	}
}
