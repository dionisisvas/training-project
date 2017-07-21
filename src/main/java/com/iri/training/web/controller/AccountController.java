package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Account;
import com.iri.training.web.service.AccountService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

	Logger logger = Logger.getLogger(AccountController.class);


	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Account>> getAllAccounts() throws SQLException {

		logger.debug("ENTERED getAllAccounts");

		ArrayList<Account> accounts = (ArrayList) accountService.getAccountList();

		logger.debug("EXITING getAllAccounts");

		if (accounts != null) {
			return new ResponseEntity<ArrayList<Account>>(accounts, HttpStatus.OK);
		}

		return new ResponseEntity<ArrayList<Account>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccount(@PathVariable("username") String username) throws SQLException {


		logger.debug("ENTERED getAccount: " + username);


		Account account = accountService.getAccount(username);

		logger.debug("EXITING getAccount " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/id/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable("accountId") Long accountId) throws SQLException {


		logger.debug("ENTERED getAccountById: " + accountId);


		Account account = accountService.getAccountById(accountId);

		logger.debug("EXITING getAccountById " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountByEmail(@PathVariable("email") String email) throws SQLException {


		logger.debug("ENTERED getAccountByEmail: " + email);


		Account account = accountService.getAccountByEmail(email);

		logger.debug("EXITING getAccountByEmail: " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}
}
