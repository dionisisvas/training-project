package com.iri.training.web.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Account;
import com.iri.training.model.User;
import com.iri.training.repository.AccountRepository;
import com.iri.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) throws SQLException {

		Account account = accountRepository.getAccount(username);

		return getUserById(account.getAccountId());
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
	public long addUserAndGetGeneratedId(User user) throws SQLException {
		return userRepository.addUserAndGetGeneratedId(user);
	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> userList = new ArrayList<User>(userRepository.getUserList());
		for (User user : userList) {
			if (user != null) {
				user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
				user.setDateOfBirth(null);
			}
		}

		return userList;
	}

	@Override public boolean verifyNewUser(final User user) throws SQLException {

		logger.debug("ENTERED verifyNewUser for " + user);

		boolean verified = true;

		LocalDate ld = LocalDate.now();

		if ((user.getName() == null) ||
			(user.getSurname() == null) ||
			(user.getDateOfBirth() == null)) {

			verified = false;
			logger.debug("Found null required fields.");
		}

		// Check if the name and surname are within the [2-64] characters range.
		if ((user.getName().length() < 2) ||
			(user.getName().length() > 64)) {

			verified = false;
			logger.debug("Invalid name.");
		}
		if ((user.getSurname().length() < 2) ||
			(user.getSurname().length() > 64)) {

			verified = false;
			logger.debug("Invalid surname.");
		}

		// Check if the user age is valid (18-125 years old).
		if ((user.getDateOfBirth().isBefore(LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth())
				.minusYears(125))) ||
			(user.getDateOfBirth().isAfter(LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth())
				.minusYears(18)))) {

			verified = false;
			logger.debug("Invalid age.");
		}

		logger.debug("EXITING verifyNewUser for " + user);

		return verified;
	}

	@Override public void updateUser(final User user) throws SQLException {
		userRepository.updateUser(user);
	}
}
