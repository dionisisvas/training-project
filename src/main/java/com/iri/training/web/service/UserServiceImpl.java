package com.iri.training.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepository;

@Service
public abstract class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long userId) throws SQLException {
		
		//implement code
		User user = userRepository.getUserById(userId);
		user =userRepository.createUser(user);
		return user;
	}

	
	
}
