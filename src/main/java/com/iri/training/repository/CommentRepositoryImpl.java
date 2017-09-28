package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.builder.CommentBuilder;

@Repository
public final class CommentRepositoryImpl implements CommentRepository {

	private static final Logger logger = Logger.getLogger(CommentRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection .getDataSource();
	private JdbcTemplate jdbcTemplate;

	@Override
	public final Comment getCommentById(final long commentId) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId);

		final Comment comment;
		jdbcTemplate = new JdbcTemplate(dataSource);

		comment = jdbcTemplate.query(PropertiesConfig.GET_COMMENT_BY_ID,
			new Object[]{commentId},
			new CommentResultSetExtractor());

		logger.debug("EXITING getCommentById with comment: " + comment);

		return comment;
	}

	@Override
	public final List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
			"with subjectId: " + subjectId);

		final List<Comment> comments;
		jdbcTemplate = new JdbcTemplate(dataSource);

		comments = new ArrayList<Comment>(
						jdbcTemplate.query(PropertiesConfig.GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID,
								new Object[]{subjectType.name(), subjectId},
								new CommentsResultSetExtractor()));

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			"with subjectId: " + subjectId);

		return comments;
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

	private static final class CommentsResultSetExtractor implements ResultSetExtractor<List<Comment>> {

		@Override
		public List<Comment> extractData(final ResultSet resultSet) throws SQLException {

			final List<Comment> comments = new ArrayList<>();

			while (resultSet.next()) {
				comments.add(new CommentBuilder()
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
					.build());
			}

			return comments;
		}
	}
}
