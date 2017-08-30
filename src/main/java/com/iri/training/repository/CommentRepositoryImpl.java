package com.iri.training.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.builder.CommentBuilder;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private InputStream resourceAsStream = CommentRepositoryImpl.class.getResourceAsStream("/sql_queries.properties");
	private PropertyResourceBundle property = new PropertyResourceBundle(resourceAsStream);


	public CommentRepositoryImpl() throws IOException {}

	@Override public Comment getCommentById(final long commentId) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId);

		final Comment comment;
		final String sql = property.getString("GET_COMMENT_BY_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		comment = jdbcTemplate.query(sql, new Object[]{commentId}, new CommentResultSetExtractor());

		logger.debug("EXITING getCommentById for commentId: " + commentId);

		return comment;
	}

	@Override public List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
			"with subjectId: " + subjectId);

		final List<Comment> comments;
		final String sql = property.getString("GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		comments = new ArrayList<Comment>(
						jdbcTemplate.query(sql,
								new Object[]{subjectType.name(), subjectId},
								new SubjectCommentsResultSetExtractor()));

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			"with subjectId: " + subjectId);

		return comments;
	}

	@Override public List<Comment> getCommentsByPoster(final long posterId) throws SQLException {

		logger.debug("ENTERED getCommentsByPoster for posterId: " + posterId);

		final List<Comment> comments;
		final String sql = property.getString("GET_COMMENTS_BY_POSTER_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		comments = new ArrayList<Comment>(
			jdbcTemplate.query(sql,
				new Object[]{posterId},
				new UserCommentsResultSetExtractor()));

		logger.debug("EXITING getCommentsByPoster for posterId: " + posterId);

		return comments;
	}

	private static final class CommentResultSetExtractor implements ResultSetExtractor<Comment> {

		@Override
		public Comment extractData(final ResultSet resultSet) throws SQLException {

			final Comment comment;

			if (resultSet.next()) {
				comment = new CommentBuilder()
					.withCommentId(resultSet.getLong("comment_id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withSubjectType(SubjectType.valueOf(
						resultSet.getString("subject_type")))
					.withSubjectId(resultSet.getLong("subject_id"))
					.withTitle(resultSet.getString("title"))
					.withContent(resultSet.getString("body"))
					.withCreationDate(LocalDate.parse(
						resultSet.getString("creation_date"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.withLastEditDate(LocalDate.parse(
						resultSet.getString("last_edit_date"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build();
			}
			else
			{
				return null;
			}

			return comment;
		}
	}

	private static final class SubjectCommentsResultSetExtractor implements ResultSetExtractor<List<Comment>> {

		@Override
		public List<Comment> extractData(final ResultSet resultSet) throws SQLException {

			final List<Comment> comments = new ArrayList<>();
			while (resultSet.next()) {
				comments.add(new CommentBuilder()
					.withCommentId(resultSet.getLong("comment_id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withTitle(resultSet.getString("title"))
					.withContent(resultSet.getString("body"))
					.withCreationDate(LocalDate.parse(
						resultSet.getString("creation_date"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.withLastEditDate(LocalDate.parse(
						resultSet.getString("last_edit_date"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build());
			}

			return comments;
		}
	}

	private static final class UserCommentsResultSetExtractor implements ResultSetExtractor<List<Comment>> {

		@Override
		public List<Comment> extractData(final ResultSet resultSet) throws SQLException {

			final List<Comment> comments = new ArrayList<>();
			while (resultSet.next()) {
				comments.add(new CommentBuilder()
					.withCommentId(resultSet.getLong("comment_id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withSubjectType(SubjectType.valueOf(
						resultSet.getString("subject_type")))
					.withSubjectId(resultSet.getLong("subject_id"))
					.withTitle(resultSet.getString("title"))
					.withCreationDate(LocalDate.parse(
						resultSet.getString("creation_date"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build());
			}

			return comments;
		}
	}
}
