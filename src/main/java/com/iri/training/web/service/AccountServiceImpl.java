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
import com.iri.training.repository.AccountRepository;

@Service
public  class AccountServiceImpl implements AccountService {
	Logger logger = Logger.getLogger(AccountServiceImpl.class);

	private static final String EMAIL_PATTERN =
		"^[[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
		"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})]{8,64}$";

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account getAccount(String username) throws SQLException {
		Account account = accountRepository.getAccount(username);

		return account;
	}

	@Override
	public Account getAccountById(Long accountId) throws SQLException {
		Account account = accountRepository.getAccountById(accountId);

		return account;
	}

	@Override public Account getAccountByEmail(final String email) throws SQLException {
		Account account = accountRepository.getAccountByEmail(email);

		return account;
	}

	@Override
	public Account createAccount(Account account) throws SQLException {
		return accountRepository.createAccount(account);
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>(accountRepository.getAccountList());

		return accountList;
	}

	@Override public boolean verifyNewAccount(final Account account) throws SQLException {

		logger.debug("ENTERED verifyNewUser for " + account);

		boolean verified = true;

		if ((account.getUsername() == null) ||
			(account.getEmail() == null) ||
			(account.getPassword() == null)) {

			verified = false;
			logger.debug("Found null required fields");
		}

		// Check if the username is alphanumeric in the [3-24] characters range.
		if (!(account.getUsername().matches("^[a-zA-Z0-9_]{3,24}$"))) {
			verified = false;
			logger.debug("Invalid username.");
		}
		// Check if the username is unique.
		if (accountRepository.getAccount(account.getUsername()) != null) {
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

		logger.debug("EXITING verifyNewUser for " + account);

		return verified;
	}
}
