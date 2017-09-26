package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.Hobby;
import com.iri.training.model.builder.HobbyBuilder;

@Repository
public class HobbyRepositoryImpl implements HobbyRepository {

	private static final Logger logger = Logger.getLogger(HobbyRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection.getDataSource();
	private JdbcTemplate jdbcTemplate;

	@Override
	public final Hobby getHobbyById(final long hobbyId) throws SQLException {

		logger.debug("ENTERED getHobbyById for hobbyId: " + hobbyId);

		final Hobby hobby;
		jdbcTemplate = new JdbcTemplate(dataSource);

		hobby = jdbcTemplate.query(PropertiesConfig.GET_HOBBY_BY_ID,
			new Object[]{hobbyId},
			new HobbyResultSetExtractor());

		logger.debug("EXITING getHobbyById with hobby: " + hobby);

		return hobby;
	}

	@Override
	public final List<Long> getUserHobbies(final long userId) throws SQLException {

		logger.debug("ENTERED getUserHobbies for userId: " + userId);

		final List<Long> userHobbies;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userHobbies = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_HOBBIES_BY_USER_ID,
			new Object[]{userId},
			new UserHobbyListResultSetExtractor()));

		logger.debug("EXITING getUserHobbies with hobby IDs: " + userHobbies);

		return userHobbies;
	}

	@Override
	public final List<Hobby> getHobbyList() throws SQLException {

		logger.debug("ENTERED getHobbyList");

		final List<Hobby> hobbyList;
		jdbcTemplate = new JdbcTemplate(dataSource);

		hobbyList = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_HOBBY_LIST,
			new HobbyListResultSetExtractor()));

		logger.debug("EXITING getHobbyList");

		return hobbyList;
	}

	private static final class HobbyResultSetExtractor implements ResultSetExtractor<Hobby> {

		@Override
		public Hobby extractData(final ResultSet resultSet) throws SQLException {

			final Hobby hobby;

			if (resultSet.next()) {
				hobby = new HobbyBuilder()
					.withHobbyId(resultSet.getLong("id"))
					.withHobbyName(resultSet.getString("name"))
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
					.withHobbyId(resultSet.getLong("id"))
					.withHobbyName(resultSet.getString("name"))
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
				userHobbyList.add(resultSet.getLong("hobby_id"));
			}

			return userHobbyList;
		}
	}
}
