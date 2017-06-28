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

import com.iri.training.model.Hobby;
import com.iri.training.model.builder.HobbyBuilder;

@Repository
public class HobbyRepositoryImpl implements HobbyRepository {
	Logger logger = Logger.getLogger(ImageRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private FileInputStream fis = new FileInputStream("src/main/resources/sql_queries.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(fis);

	public HobbyRepositoryImpl() throws IOException {}

	@Override
	public Hobby getHobbyById(Long hobbyId) throws SQLException {
		logger.debug("ENTERED getHobbyById for hobbyId: " + hobbyId);

		final Hobby hobby;

		String sql = property.getString("RETRIEVE_HOBBY");
		jdbcTemplate = new JdbcTemplate(dataSource);
		hobby = jdbcTemplate.query(sql, new Object[]{hobbyId}, new HobbyResultSetExtractor());

		logger.debug("EXITING getHobbyById: " + hobby);

		return hobby;
	}

	@Override
	public List<Long> getUserHobbies(Long userId) throws SQLException {
		logger.debug("ENTERED getUserHobbies for userId: " + userId);

		String sql = property.getString("RETRIEVE_USER_HOBBIES");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Long> userHobbies = jdbcTemplate.query(sql, new Object[]{userId}, new UserHobbyListResultSetExtractor());

		logger.debug("EXITING getUserHobbies: " + userHobbies);

		return userHobbies;
	}

	@Override
	public List<Hobby> getHobbyList() throws SQLException {
		logger.debug("ENTERED getHobbyList");

		String sql = property.getString("RETRIEVE_HOBBY_LIST");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Hobby> hobbies = jdbcTemplate.query(sql, new HobbyListResultSetExtractor());

		logger.debug("EXITING getHobbyList: " + hobbies);

		return hobbies;
	}

	private static final class HobbyResultSetExtractor implements ResultSetExtractor<Hobby> {

		@Override
		public Hobby extractData(final ResultSet resultSet) throws SQLException {

			final Hobby hobby;

			if (resultSet.next()) {
				hobby = new HobbyBuilder()
					.withHobbyId(resultSet.getLong("hobbyId"))
					.withHobbyName(resultSet.getString("hobbyName"))
					.withDescription(resultSet.getString("description"))
					.build();
			}
			else
			{
				return null;
			}

			return hobby;
		}
	}

	private static final class HobbyListResultSetExtractor implements ResultSetExtractor<List<Hobby>> {

		@Override
		public List<Hobby> extractData(final ResultSet resultSet) throws SQLException {

			final List<Hobby> hobbyList = new ArrayList<>();
			while (resultSet.next()) {
				hobbyList.add(new HobbyBuilder()
					.withHobbyId(resultSet.getLong("hobbyId"))
					.withHobbyName(resultSet.getString("hobbyName"))
					.withDescription(resultSet.getString("description"))
					.build());
			}

			return hobbyList;
		}
	}

	private static final class UserHobbyListResultSetExtractor implements ResultSetExtractor<List<Long>> {

		@Override
		public List<Long> extractData(final ResultSet resultSet) throws SQLException {

			final List<Long> userHobbyList = new ArrayList<>();
			while (resultSet.next()) {
				userHobbyList.add(resultSet.getLong("hobbyId"));
			}

			return userHobbyList;
		}
	}
}
