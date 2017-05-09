package com.iri.training.repository;

import com.iri.training.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;

import javax.sql.DataSource;

public interface UserRepository {

	User getUserById(Long userId) throws SQLException;

	

	String name =  UserRepositoryImpl.getName();
	String surname = UserRepositoryImpl.getSurname();
	String username = UserRepositoryImpl.getUsername();
	String password = UserRepositoryImpl.getPassword();
}


