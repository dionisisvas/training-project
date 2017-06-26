package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Account;
import com.iri.training.web.service.AccountService;

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
		if (accounts != null) {
			return new ResponseEntity<ArrayList<Account>>(accounts, HttpStatus.OK);
		}

		logger.debug("EXITING getAllAccounts");

		return new ResponseEntity<ArrayList<Account>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccount(@PathVariable("username") String username) throws SQLException {


		logger.debug("ENTERED getAccount: " + username);


		Account account = accountService.getAccount(username);
		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}


		logger.debug("EXITING getAccount " + account);


		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/uid/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable("userId") Long userId) throws SQLException {


		logger.debug("ENTERED getAccountById: " + userId);


		Account account = accountService.getAccountById(userId);
		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		logger.debug("EXITING getAccountById " + account);


		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createAccount(@RequestBody Account account) throws SQLException {
		logger.debug("ENTERED createAccount: " + account);

		accountService.createAccount(account);

		logger.debug("EXITING createAccount: " + account);

		return new ResponseEntity(HttpStatus.OK);
	}
}
