package com.iri.training.repository;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iri.training.model.User;

@Repository
public  class UserRepositoryImpl implements UserRepository {
	Logger logger = Logger.getLogger(UserRepositoryImpl.class);
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {

		this.dataSource = dataSource;
	}
	private User user = null;
	public User getUserById(Long userId ) throws SQLException {

			logger.debug("ENTERED getUserById" + user.toString());



		String sql = "SELECT * FROM USERS WHERE usrID= ?;";
		jdbcTemplate=new JdbcTemplate(dataSource);
		user=jdbcTemplate.queryForObject(sql,new Object[]{userId},User.class);


		logger.debug("EXITING getUserById " + user.toString());

		return user;
	}
	@Override
	public User createUser(final User user) throws SQLException {
		logger.debug("ENTERED createUser" + user.toString());



			String sql = "INSERT INTO USERS(username, userID, name, surname, age, phone, address, password)VALUES(?,?,?,?,?,?,?,?);";
		jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,user.getUsername(),user.getUserID(),user.getName(),user.getSurname(),user.getAge(),user.getPhone(),user.getAddress(),user.getPassword());
		System.out.print("User Inserted Successfully");

		logger.debug("EXITING createUser " + user.toString());
		return user;
	}

}
