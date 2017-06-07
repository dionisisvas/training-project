package com.iri.training.web.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepository;

@Service
public  class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long userId) throws SQLException {
		logger.debug("ENTERED getUserById: " + userId);

		 User user = userRepository.getUserById(userId);
		logger.debug("EXITING getUserById " + user);
		return user;
	}

	@Override
	public User createUser(User user) throws SQLException {

		logger.debug("ENTERED createUser: " + user);
		userRepository.createUser(user);
		logger.debug("EXITING createUser: " + user);
		return user;
	}

}
