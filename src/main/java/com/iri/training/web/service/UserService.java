package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayDeque;

import com.iri.training.model.User;


public interface UserService {


	User getUserById(Long userId) throws SQLException;
	
	ArrayDeque<User> getUserArray() throws SQLException;
	
	User createUser(User user) throws SQLException;
}