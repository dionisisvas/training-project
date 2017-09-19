package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Account;

public interface AccountService {

	Account getAccountById(long accountId) throws SQLException;

	Account getAccountByUsername(String username) throws SQLException;

	Account getAccountByEmail(String email) throws SQLException;

	List<Account> getAccountList() throws SQLException;

	void addAccount(Account account) throws SQLException;

	void editAccount(Account account) throws SQLException;

	boolean verifyNewAccount(Account account) throws SQLException;
}
