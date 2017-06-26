package com.iri.training.web.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
	public User getUser(String username) throws SQLException {
		User user = userRepository.getUser(username);
		if (user != null) {
			user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
		}

		return user;
	}

	@Override
	public User getUserById(Long userId) throws SQLException {
		User user = userRepository.getUserById(userId);
		if (user != null) {
			user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
		}

		return user;
	}

	@Override
	public User createUser(User user) throws SQLException {
		return userRepository.createUser(user);
	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<User>(userRepository.getUserList());
		for (User user : userList) {
			if (user != null) {
				user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
			}
		}

		return userList;
	}
}
