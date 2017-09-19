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
import com.iri.training.repository.UserRepository;

@Service
public final class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	AccountService accountService;

	@Autowired
	UserRepository userRepository;

	@Override
	public final User getUserById(final long userId) throws SQLException {

		logger.debug("ENTERED getUserById for userId: " + userId);

		final User user = userRepository.getUserById(userId);
		if (user != null) {
			// Age is not stored in the db.
			user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
		}

		logger.debug("EXITING getUserById with user: " + user);

		return user;
	}

	@Override
	public final User getUserByUsername(final String username) throws SQLException {

		logger.debug("ENTERED getUserByUsername for username: " + username);

		final Account account = accountService.getAccountByUsername(username);
		final User user = getUserById(account.getId());
		if (user != null) {
			// Age is not stored in the db.
			user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
		}

		logger.debug("EXITING getUserByUsername with user: " + user);

		return user;
	}

	@Override
	public final List<User> getUserList() throws SQLException {

		logger.debug("ENTERED getUserList");

		final List<User> userList = new ArrayList<>(userRepository.getUserList());

		for (User user : userList) {
			if (user != null) {
				// Age is not stored in the db so calculate it for each user.
				// Also, hide the exact date of birth.
				user.setAge((short) (ChronoUnit.YEARS.between(user.getDateOfBirth(), LocalDate.now())));
				user.setDateOfBirth(null);
			}
		}

		logger.debug("EXITING getUserList");

		return userList;
	}

	/*
	 * Method that adds a new user in the database and returns the auto-generated user ID,
	 * or null if the operation fails.
	 */
	@Override
	public final Long addUserAndGetGeneratedId(final User user) {

		logger.debug("ENTERED addUserAndGetGeneratedId for user: " + user);

		final Long userId;

		try {
			userId = userRepository.addUserAndGetGeneratedId(user);
		}
		catch (SQLException e) {
			logger.warn("EXITING addUserAndGetGenerate and returning null. Exception: " + e);

			return null;
		}

		logger.debug("EXITING addUserAndGetGeneratedId for user: " + user +
			" with generated user ID: " + userId);

		return userId;
	}

	@Override
	public final void editUser(final User user) throws SQLException {

		logger.debug("ENTERED editAccount for user: " + user);

		userRepository.editUser(user);

		logger.debug("EXITING editAccount for user: " + user);
	}

	@Override
	public final boolean verifyNewUser(final User user) {

		logger.debug("ENTERED verifyNewUser for user: " + user);

		boolean verified = true;
		final LocalDate ld = LocalDate.now();

		if ((user.getName() == null) ||
			(user.getSurname() == null) ||
			(user.getDateOfBirth() == null)) {

			verified = false;

			logger.debug("Found null required fields. Verification failed for user: " + user);
		}

		// Check if the name and surname are within the [2-64] characters range.
		if ((user.getName().length() < 2) ||
			(user.getName().length() > 64)) {

			verified = false;

			logger.debug("Invalid name. Verification failed for user: " + user);
		}

		if ((user.getSurname().length() < 2) ||
			(user.getSurname().length() > 64)) {

			verified = false;

			logger.debug("Invalid surname. Verification failed for user: " + user);
		}

		// Check if the user age is valid (18-125 years old).
		if ((user.getDateOfBirth().isBefore(LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth())
				.minusYears(125))) ||
			(user.getDateOfBirth().isAfter(LocalDate.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth())
				.minusYears(18)))) {

			verified = false;

			logger.debug("Invalid age. Verification failed for user: " + user);
		}

		logger.debug("EXITING verifyNewUser for user: " + user);

		return verified;
	}
}
