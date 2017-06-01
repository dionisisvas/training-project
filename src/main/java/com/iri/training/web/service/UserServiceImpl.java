package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepository;

@Service
public  class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long userId) throws SQLException {
		return 	userRepository.getUserById(userId);
	}

	@Override
	public User createUser(User user) throws SQLException {
		return userRepository.createUser(user);
	}

	@Override
	public ArrayDeque<User> getUserArray() throws SQLException {
		return userRepository.getUserArray();
	}
}
