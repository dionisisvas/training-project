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
	public boolean verifyNewAccount(final Account account) {

		if ((account.getUsername() == null) ||
			(account.getEmail() == null) ||
			(account.getPassword() == null)) {

			return false;
		}

		boolean verified = true;

		// Check if the username is alphanumeric in the [3-24] characters range.
		verified = verified && (account.getUsername().matches("^[a-zA-Z0-9]{3,24}$"));
		// Check if the email is valid.
		verified = verified && (account.getEmail().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"));
		// Check if the password is within the [8-64] characters range.
		verified = verified && ((account.getPassword().length() >= 8) &&
								(account.getPassword().length() <= 64));

		return verified;
	}

	@Override
	public List<Account> getAccountList() throws SQLException {
		List<Account> accountList = new ArrayList<Account>(accountRepository.getAccountList());

		return accountList;
	}
}
