package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.User;

public interface UserRepository {

	User getUserById(long userId) throws SQLException;

	List<User> getUserList() throws SQLException;

	long addUserAndGetGeneratedId(User user) throws SQLException;

	void updateUser(User user) throws SQLException;
}
