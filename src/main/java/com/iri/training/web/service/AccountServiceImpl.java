package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Account;
import com.iri.training.repository.AccountRepository;

@Service
public final class AccountServiceImpl implements AccountService {

	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);

	private static final String EMAIL_PATTERN =
		"^[[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
		"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})]{8,64}$";

	@Autowired
	AccountRepository accountRepository;

	@Override
	public final Account getAccountById(final long accountId) throws SQLException {

		logger.debug("ENTERED getAccountById for accountId: " + accountId);

		final Account account = accountRepository.getAccountById(accountId);

		logger.debug("EXITING getAccountById with account: " + account);

		return account;
	}

	@Override
	public final Account getAccountByUsername(final String username) throws SQLException {

		logger.debug("ENTERED getAccountByUsername for username: " + username);

		final Account account = accountRepository.getAccountByUsername(username);

		logger.debug("EXITING getAccountByUsername with account: " + account);

		return account;
	}

	@Override
	public final Account getAccountByEmail(final String email) throws SQLException {

		logger.debug("ENTERED getAccountByEmail for email: " + email);

		final Account account = accountRepository.getAccountByEmail(email);

		logger.debug("EXITING getAccountByEmail with account: " + account);

		return account;
	}

	public final List<Account> getAccountList() throws SQLException {

		logger.debug("ENTERED getAccountList");

		final List<Account> accounts = new ArrayList<>(accountRepository.getAccountList());

		logger.debug("EXITING getAccountList");

		return accounts;
	}

	@Override
	public final void addAccount(final Account account) throws SQLException {

		logger.debug("ENTERED addAccount for account: " + account);

		accountRepository.addAccount(account);

		logger.debug("EXITING addAccount for account: " + account);
	}

	@Override
	public final void editAccount(final Account account) throws SQLException {

		logger.debug("ENTERED editAccount for account: " + account);

		accountRepository.editAccount(account);

		logger.debug("EXITING editAccount for account: " + account);
	}

	@Override
	public final boolean verifyNewAccount(final Account account) throws SQLException {

		logger.debug("ENTERED verifyNewAccount for " + account);

		boolean verified = true;

		if ((account.getUsername() == null) ||
			(account.getEmail() == null) ||
			(account.getPassword() == null)) {

			verified = false;
			logger.debug("Found null required fields.");
		}

		// Username can be alphanumeric with underscores in the [3-24] characters range.
		if (!(account.getUsername().matches("^[a-zA-Z0-9_]{3,24}$"))) {
			verified = false;
			logger.debug("Invalid username.");
		}
		// Check if the username is unique.
		if (accountRepository.getAccountByUsername(account.getUsername()) != null) {
			verified = false;
			logger.debug("Username already exists.");
		}

		// Check if the email is valid.
		if (!(account.getEmail().matches(EMAIL_PATTERN))) {
			verified = false;
			logger.debug("Invalid email.");
		}
		// Check if the e-mail is in use.
		if (accountRepository.getAccountByEmail(account.getEmail()) != null) {
			verified = false;
			logger.debug("E-mail in use.");
		}

		// Check if the password is strong enough.
		// 8-64 chars length, contains at least one of each:
		// * lowercase letter,      : (?=.*[a-z])
		// * uppercase letter,      : (?=.*[A-Z])
		// * numeral character and  : (?=.*[0-9])
		// * special character.     : (?=.*[\p{Punct}])
		if (!(account.getPassword().matches(
			"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\p{Punct}]).{8,64}$"))) {
			verified = false;
			logger.debug("Weak password.");
		}

		logger.debug("EXITING verifyNewAccount for " + account);

		return verified;
	}
}
