package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iri.training.model.User;
import com.iri.training.model.builder.UserBuilder;

@Repository
public  class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	private JdbcTemplate jdbcTemplate;
	ConnectToBase connectToBase=new ConnectToBase();
	private DataSource dataSource=connectToBase.getDataSource();


	public UserRepositoryImpl() throws IOException {}

	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
	}


	FileInputStream fis = new FileInputStream("File/app_sql.properties");
	java.util.PropertyResourceBundle propety = new java.util.PropertyResourceBundle(fis);
	@Override
	@Cacheable(value="findUser",key="#userId")
	public User getUserById(Long userId ) throws SQLException {

		logger.debug("ENTERED getUserById: " + userId);

		String sql =propety.getString("SELECT_USER");
		jdbcTemplate=new JdbcTemplate(dataSource);
		User user=jdbcTemplate.queryForObject(sql,new Object[]{userId},new UserMapper());

		logger.debug("EXITING getUserById " + user);

		return user;
	}
	@Override
	public User createUser(final User user) throws SQLException {
		logger.debug("ENTERED createUser: " + user);

		String sql = propety.getString("CREATE_USER");
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,user.getUsername(),user.getUserID(),user.getName(),user.getSurname(),user.getAge(),user.getPhone(),user.getAddress(),user.getPassword());
		System.out.print("User Inserted Successfully");

		logger.debug("EXITING createUser: " + user);
		return user;
	}

	private static final class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(final ResultSet resultSet, final int i) throws SQLException {

			User user = new UserBuilder().withName(resultSet.getString("name")).withSurname(resultSet.getString("surname"))
				.withUsername(resultSet.getString("username")).withPassword(resultSet.getString("password")).withAge(resultSet.getInt("age"))
				.withPhone(resultSet.getString("phone")).withAddress(resultSet.getString("address")).withUserID(resultSet.getInt("usrID"))
				.build();

			return user;
		}
	}
}
