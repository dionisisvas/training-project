package com.iri.training.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.iri.training.model.Post;
import com.iri.training.model.builder.PostBuilder;

@Repository
public final class PostRepositoryImpl implements PostRepository {

	private static final Logger logger = Logger.getLogger(PostRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection .getDataSource();
	private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	@Override
	public final Post getPostById(final long postId) throws SQLException {

		logger.debug("ENTERED getPostById for postId: " + postId);

		final Post post;

		post = jdbcTemplate.query(PropertiesConfig.GET_POST_BY_ID,
			new Object[]{postId},
			new PostResultSetExtractor());

		logger.debug("EXITING getPostById with post: " + post);

		return post;
	}

	@Override
	public final List<Post> getPostsBySubject(final SubjectType subjectType, final long subjectId) throws SQLException {

		logger.debug("ENTERED getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId);

		final List<Post> posts;

		posts = new ArrayList<Post>(
						jdbcTemplate.query(PropertiesConfig.GET_POSTS_BY_SUBJECT_TYPE_AND_ID,
								new Object[]{subjectType.name(), subjectId},
								new PostsBySubjectResultSetExtractor()));

		logger.debug("EXITING getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId);

		return posts;
	}

	@Override
	public final List<Post> getPostsByPoster(final long posterId) throws SQLException {

		logger.debug("ENTERED getPostsByPoster for posterId: " + posterId);

		final List<Post> posts;

		posts = new ArrayList<Post>(
			jdbcTemplate.query(PropertiesConfig.GET_POSTS_BY_POSTER_ID,
				new Object[]{posterId},
				new PostsByPosterResultSetExtractor()));

		logger.debug("EXITING getPostsByPoster for posterId: " + posterId);

		return posts;
	}

	@Override
	public final long addPostAndGetGeneratedId(final Post post) throws SQLException {

		logger.debug("ENTERED addPostAndGetGeneratedId for post: " + post);

		final KeyHolder kh = new GeneratedKeyHolder();
		final long postId;

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override public PreparedStatement createPreparedStatement(final Connection connection)
				throws SQLException {
				PreparedStatement ps = connection.prepareStatement(PropertiesConfig.ADD_POST,
					Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, post.getPosterId());
				ps.setString(2, post.getSubjectType().name());
				ps.setLong(3, post.getSubjectId());
				ps.setString(4, post.getTitle());
				ps.setString(5, post.getContent());
				ps.setLong(6, Instant.now().getEpochSecond()); // creation_date

				return ps;
			}
		}, kh);


		postId = kh.getKey().longValue();

		logger.debug("EXITING addPostAndGetGeneratedId for post: " + post +
			" with generated post ID: " + postId);

		return postId;
	}

	@Override
	public final void deletePost(final long postId) throws SQLException {

		logger.debug("ENTERED deletePost for postId: " + postId);

		jdbcTemplate.update(PropertiesConfig.DELETE_POST, postId);

		logger.debug("EXITING deletePost for postId: " + postId);
	}

	@Override
	public final void editPost(final Post post) throws SQLException {

		logger.debug("ENTERED editPost for post: " + post);

		jdbcTemplate.update(PropertiesConfig.EDIT_POST,
			post.getTitle(),
			post.getContent(),
			Instant.now().getEpochSecond(),
			post.getId());

		logger.debug("EXITING editPost for post: " + post);
	}

	private static final class PostResultSetExtractor implements ResultSetExtractor<Post> {

		@Override
		public Post extractData(final ResultSet resultSet) throws SQLException {

			final Post post;

			if (resultSet.next()) {
				post = new PostBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withSubjectType(SubjectType.valueOf(
						resultSet.getString("subject_type")))
					.withSubjectId(resultSet.getLong("subject_id"))
					.withTitle(resultSet.getString("title"))
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

			return post;
		}
	}

	private static final class PostsBySubjectResultSetExtractor implements ResultSetExtractor<List<Post>> {

		@Override
		public List<Post> extractData(final ResultSet resultSet) throws SQLException {

			final List<Post> posts = new ArrayList<>();

			while (resultSet.next()) {
				posts.add(new PostBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withTitle(resultSet.getString("title"))
					.withContent(resultSet.getString("content"))
					.withCreationDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("creation_date"),
						0, ZoneOffset.UTC))
					.withLastEditDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("last_edit_date"),
						0, ZoneOffset.UTC))
					.build());
			}

			return posts;
		}
	}

	private static final class PostsByPosterResultSetExtractor implements ResultSetExtractor<List<Post>> {

		@Override
		public List<Post> extractData(final ResultSet resultSet) throws SQLException {

			final List<Post> posts = new ArrayList<>();

			while (resultSet.next()) {
				posts.add(new PostBuilder()
					.withId(resultSet.getLong("id"))
					.withPosterId(resultSet.getLong("poster_id"))
					.withSubjectType(SubjectType.valueOf(
						resultSet.getString("subject_type")))
					.withSubjectId(resultSet.getLong("subject_id"))
					.withTitle(resultSet.getString("title"))
					.withContent(resultSet.getString("content"))
					.withCreationDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("creation_date"),
						0, ZoneOffset.UTC))
					.withLastEditDate(LocalDateTime.ofEpochSecond(
						resultSet.getLong("last_edit_date"),
						0, ZoneOffset.UTC))
					.build());
			}

			return posts;
		}
	}
}
