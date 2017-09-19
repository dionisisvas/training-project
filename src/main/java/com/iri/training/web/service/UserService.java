package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.User;

public interface UserService {

	User getUserById(long userId) throws SQLException;

	User getUserByUsername(String username) throws SQLException;

	List<User> getUserList() throws SQLException;

	Long addUserAndGetGeneratedId(User user);

	void editUser(User user) throws SQLException;

	boolean verifyNewUser(User user);
}
