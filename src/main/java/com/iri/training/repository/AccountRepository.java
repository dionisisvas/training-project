package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Account;

public interface AccountRepository {

	Account getAccount(String username) throws SQLException;

	Account getAccountById(Long accountId) throws SQLException;

	Account getAccountByEmail(String email) throws SQLException;

	List<Account> getAccountList() throws SQLException;

	void createAccount(Account account) throws SQLException;
}
