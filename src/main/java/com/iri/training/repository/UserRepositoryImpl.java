package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.model.User;
import com.iri.training.model.builder.UserBuilder;

@Repository
public class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;
	private ConnectToBase dbConnection = new ConnectToBase();
	private DataSource dataSource = dbConnection .getDataSource();
	private FileInputStream fis = new FileInputStream("File/app_sql.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(fis);

	public UserRepositoryImpl() throws IOException {}

	@Override
	@Cacheable(value="findUser", key="#userId")
	public User getUserById(Long userId ) throws SQLException {
		logger.debug("ENTERED getUserById: " + userId);

		final User user;
		String sql = property.getString("RETRIEVE_USER");
		jdbcTemplate = new JdbcTemplate(dataSource);
		user = jdbcTemplate.query(sql, new Object[]{userId}, new UserResultSetExtractor());

		logger.debug("EXITING getUserById " + user);

		return user;
	}

	@Override
	public List<User> getUserList() throws SQLException {
		logger.debug("ENTERED getUserList");

		String sql = property.getString("RETRIEVE_USER_LIST");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<User> usersList = jdbcTemplate.query(sql, new UserListResultSetExtractor());

		logger.debug("EXITING getUserList");

		return usersList;
	}

	@Override
	public User createUser(final User user) throws SQLException {

		logger.debug("ENTERED createUser: " + user);

		String sql = property.getString("CREATE_USER");
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, user.getUsername(),
								 user.getUserId(),
								 user.getName(),
								 user.getSurname(),
								 user.getDateOfBirth(),
								 user.getPhoneNo(),
								 user.getAddress());
		System.out.print("User Inserted Successfully");

		logger.debug("EXITING createUser: " + user);
		return user;
	}

	private static final class UserResultSetExtractor implements ResultSetExtractor<User> {

		@Override
		public User extractData(final ResultSet resultSet) throws SQLException {

			final User user;

			if (resultSet.next()) {
				user = new UserBuilder()
					.withUsername(resultSet.getString("username"))
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
					.withUsername(resultSet.getString("username"))
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
