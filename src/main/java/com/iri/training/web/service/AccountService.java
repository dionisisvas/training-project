package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Account;

public interface AccountService {

	Account getAccount(String username) throws SQLException;

	Account getAccountById(Long accountId) throws SQLException;

	Account getAccountByEmail(String email) throws SQLException;

	List<Account> getAccountList() throws SQLException;

	Account createAccount(Account account) throws SQLException;

	boolean verifyNewAccount(Account account);
}