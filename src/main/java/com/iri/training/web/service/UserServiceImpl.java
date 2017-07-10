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
import com.iri.training.repository.AccountRepository;
import com.iri.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) throws SQLException {
		User user = userRepository.getUserByUsername(username);

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
	public User addUser(User user) throws SQLException {
		return userRepository.addUser(user);
	}

	@Override public boolean verifyNewUser(final User user) {

		if ((user.getUsername() == null) ||
			(user.getName() == null) ||
			(user.getSurname() == null) ||
			(user.getDateOfBirth() == null)) {

			return false;
		}

		boolean verified = true;

		// Check if the username is alphanumeric in the [3-24] characters range.
		verified = verified && (user.getUsername().matches("^[a-zA-Z0-9]{3,24}$"));
		// Check if the name and surname are within the [2-64] characters range.
		verified = verified && ((user.getName().length() >= 2) &&
			(user.getName().length() <= 64));
		verified = verified && ((user.getSurname().length() >= 2) &&
			(user.getSurname().length() <= 64));
		// Check if the date is within acceptable ranges.
		verified = verified && ((user.getDateOfBirth().isBefore(LocalDate.of(1999, 1, 1))) &&
								(user.getDateOfBirth().isAfter(LocalDate.of(1900, 1, 1))));

		// Check if the address and the phone are within the [2-64] characters range, if they were provided.
		if (user.getAddress() != null) {
			verified = verified && ((user.getAddress().length() >= 2) &&
				(user.getAddress().length() <= 64));
		}
		if (user.getPhoneNo() != null) {
			verified = verified && ((user.getPhoneNo().length() >= 2) &&
				(user.getPhoneNo().length() <= 64));
		}

		return verified;

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
