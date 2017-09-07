package com.iri.training.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.iri.training.model.User;
import com.iri.training.model.builder.UserBuilder;

@Repository
public class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private InputStream resourceAsStream = this.getClass().getResourceAsStream("/sql_queries.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(resourceAsStream);

	public UserRepositoryImpl() throws IOException {}

	@Override
	@Cacheable(value="findUser", key="#userId")
	public User getUserById(Long userId ) throws SQLException {
		logger.debug("ENTERED getUserById for userId: " + userId);

		final User user;
		String sql = property.getString("RETRIEVE_USER_BY_ID");
		jdbcTemplate = new JdbcTemplate(dataSource);
		user = jdbcTemplate.query(sql, new Object[]{userId}, new UserResultSetExtractor());

		logger.debug("EXITING getUserById: " + user);

		return user;
	}

	@Override
	public List<User> getUserList() throws SQLException {
		logger.debug("ENTERED getUserList");

		String sql = property.getString("RETRIEVE_USER_LIST");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<User> usersList = jdbcTemplate.query(sql, new UserListResultSetExtractor());

		logger.debug("EXITING getUserList: " + usersList);

		return usersList;
	}

	@Override
	public long addUserAndGetGeneratedId(final User user) throws SQLException {

		logger.debug("ENTERED addUserAndGetGeneratedId for user: " + user);

		final KeyHolder kh = new GeneratedKeyHolder();
		final long userId;
		String sql = property.getString("ADD_USER");
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override public PreparedStatement createPreparedStatement(final Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getSurname());
				ps.setString(3, user.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE));

				return ps;
			}
		}, kh);

		userId = kh.getKey().longValue();

		logger.debug("EXITING addUserAndGetGeneratedId for user: " + user + " with generated userId: " + userId);

		return userId;
	}

	@Override
	public void updateUser(final User user) throws SQLException {

		logger.debug("ENTERED updateUser for user: " + user);

		String sql = property.getString("UPDATE_USER");
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,user.getName(),
			user.getSurname(),
			user.getAddress(),
			user.getPhoneNo(),
			user.getUserId());

		logger.debug("EXITING updateUser: " + user);
	}

	private static final class UserResultSetExtractor implements ResultSetExtractor<User> {

		@Override
		public User extractData(final ResultSet resultSet) throws SQLException {

			final User user;

			if (resultSet.next()) {
				user = new UserBuilder()
					.withUserId(resultSet.getLong("userId"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withDateOfBirth(LocalDate.parse(
						resultSet.getString("dob"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.withPhoneNo(resultSet.getString("phoneNo"))
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
					.withUserId(resultSet.getLong("userId"))
					.withName(resultSet.getString("name"))
					.withSurname(resultSet.getString("surname"))
					.withDateOfBirth(LocalDate.parse(
						resultSet.getString("dob"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build());
			}

			return userList;
		}
	}
}
