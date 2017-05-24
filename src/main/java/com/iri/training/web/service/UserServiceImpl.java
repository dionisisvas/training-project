package com.iri.training.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepository;

@Service
public  class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long userId) throws SQLException, ClassNotFoundException {
		

		 userRepository.getUserById(userId);

		return null;
	}

	@Override
	public User createUser(User user) throws SQLException, ClassNotFoundException {


		userRepository.createUser(user);
		return user;
	}

}
