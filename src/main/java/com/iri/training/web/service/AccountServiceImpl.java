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
	public Account getAccountById(Long userId) throws SQLException {
		Account account = accountRepository.getAccountById(userId);

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
}
