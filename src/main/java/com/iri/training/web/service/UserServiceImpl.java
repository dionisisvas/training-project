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

	@Override public boolean verifyNewUser(final User user) {

		logger.debug("ENTERED verifyNewUser for " + user);

		boolean verified = true;

		if ((user.getUsername() == null) ||
			(user.getName() == null) ||
			(user.getSurname() == null) ||
			(user.getDateOfBirth() == null)) {

			verified = false;

			logger.debug("Found null fields");
		}



		// Check if the username is alphanumeric in the [3-24] characters range.
		verified = verified && (user.getUsername().matches("^[a-zA-Z0-9]{3,24}$"));
		if (!verified) {
			logger.debug("Invalid username.");
		}

		// Check if the name and surname are within the [2-64] characters range.
		verified = verified && ((user.getName().length() >= 2) &&
			(user.getName().length() <= 64));
		if (!verified) {
			logger.debug("Invalid name.");
		}
		verified = verified && ((user.getSurname().length() >= 2) &&
			(user.getSurname().length() <= 64));
		if (!verified) {
			logger.debug("Invalid surname.");
		}

		// Check if the date is within acceptable ranges.
		verified = verified && ((user.getDateOfBirth().isBefore(LocalDate.of(1999, 1, 1))) &&
			(user.getDateOfBirth().isAfter(LocalDate.of(1900, 1, 1))));
		if (!verified) {
			logger.debug("Invalid age.");
		}

		logger.debug("EXITING verifyNewUser for " + user);

		return verified;
	}
}
