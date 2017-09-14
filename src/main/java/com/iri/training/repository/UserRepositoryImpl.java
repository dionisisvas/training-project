package com.iri.training.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.User;
import com.iri.training.model.builder.UserBuilder;

@Repository
public final class UserRepositoryImpl implements UserRepository {

	private static final Logger logger = Logger.getLogger(UserRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection.getDataSource();
	private JdbcTemplate jdbcTemplate;

	@Override
	@Cacheable(value="findUser", key="#id")
	public final User getUserById(final long userId) throws SQLException {

		logger.debug("ENTERED getUserById for ID: " + userId);

		final User user;
		jdbcTemplate = new JdbcTemplate(dataSource);

		user = jdbcTemplate.query(PropertiesConfig.GET_USER_BY_ID,
			new Object[]{userId},
			new UserResultSetExtractor());

		logger.debug("EXITING getUserById for user: " + user);

		return user;
	}

	@Override
	public final List<User> getUserList() throws SQLException {

		logger.debug("ENTERED getUserList");

		final List<User> userList;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userList = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_USER_LIST,
			new UserListResultSetExtractor()));

		logger.debug("EXITING getUserList");

		return userList;
	}

	@Override
	public final long addUserAndGetGeneratedId(final User user) throws SQLException {

		logger.debug("ENTERED addUserAndGetGeneratedId for user: " + user);

		final KeyHolder kh = new GeneratedKeyHolder();
		final long userId;
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override public PreparedStatement createPreparedStatement(final Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(PropertiesConfig.ADD_USER,
					Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getSurname());
				ps.setString(3, user.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE));

				return ps;
			}
		}, kh);

		userId = kh.getKey().longValue();

		logger.debug("EXITING addUserAndGetGeneratedId for user: " + user +
			" with generated user ID: " + userId);

		return userId;
	}

	private static final class UserResultSetExtractor implements ResultSetExtractor<User> {

		@Override
		public User extractData(final ResultSet resultSet) throws SQLException {

			final User user;

			if (resultSet.next()) {
				user = new UserBuilder()
					.withId(resultSet.getLong("id"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withDateOfBirth(LocalDate.parse(
						resultSet.getString("date_of_birth"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.withPhoneNo(resultSet.getString("phone_no"))
					.withAddress(resultSet.getString("address"))
					.build();
			}
			else
			{
				return null;
			}

			return user;
		}
	}

	private static final class UserListResultSetExtractor implements ResultSetExtractor<List<User>> {

		@Override
		public List<User> extractData(final ResultSet resultSet) throws SQLException {

			final List<User> userList = new ArrayList<>();

			while (resultSet.next()) {
				userList.add(new UserBuilder()
					.withId(resultSet.getLong("id"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withDateOfBirth(LocalDate.parse(
						resultSet.getString("date_of_birth"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build());
			}

			return userList;
		}
	}
}
