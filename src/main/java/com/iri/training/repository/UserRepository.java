package com.iri.training.repository;

import java.sql.SQLException;
import java.util.ArrayDeque;

import com.iri.training.model.User;


public interface UserRepository {

	User getUserById(Long userId) throws SQLException;
	
	ArrayDeque<User> getUserArray() throws SQLException;
	
	User createUser(User user) throws SQLException;		
}
