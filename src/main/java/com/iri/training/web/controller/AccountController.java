package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

	private static final Logger logger = Logger.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "{accountId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Account> getAccountById(@PathVariable("accountId") final long accountId) throws SQLException {

		logger.debug("ENTERED getAccountById for accountId: " + accountId);

		final Account account = accountService.getAccountById(accountId);

		logger.debug("EXITING getAccountById with account: " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Account> getAccountByUsername(@PathVariable("username") final String username) throws SQLException {

		logger.debug("ENTERED getAccountByUsername for username: " + username);

		final Account account = accountService.getAccountByUsername(username);

		logger.debug("EXITING getAccountByUsername with account: " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/email/{email:.+}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Account> getAccountByEmail(@PathVariable("email") final String email) throws SQLException {

		logger.debug("ENTERED getAccountByEmail for email: " + email);

		final Account account = accountService.getAccountByEmail(email);

		logger.debug("EXITING getAccountByEmail with account: " + account);

		if (account != null) {
			return new ResponseEntity<Account>(account, HttpStatus.OK);
		}

		return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<Account>> getAccountList() throws SQLException {

		logger.debug("ENTERED getAccountList");

		final List<Account> accounts = new ArrayList<>(accountService.getAccountList());

		logger.debug("EXITING getAccountList");

		if (accounts != null) {
			return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		}

		return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public final ResponseEntity<String>  editAccount(@RequestBody final Account account) throws SQLException {

		logger.debug("ENTERED editAccount for account: " + account );

		accountService.editAccount(account);

		logger.debug("EXITING editAccount: " + account);

		return new ResponseEntity("{\"message\": \"Update success.\"}", HttpStatus.OK);
	}

	@RequestMapping(value = "/is-unique/username/{username}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> isUsernameUnique(@PathVariable("username") final String username) throws SQLException {

		logger.debug("ENTERED isUsernameUnique for username: " + username);

		final boolean isUnique;

		if (accountService.getAccountByUsername(username) != null) {
			isUnique = false;
		}
		else {
			isUnique = true;
		}

		logger.debug("EXITING isUsernameUnique for username: " + username + ", with result: " + isUnique);

		return new ResponseEntity("{\"isUnique\": " + isUnique +"}", HttpStatus.OK);
	}

	@RequestMapping(value = "/is-unique/email/{email:.+}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> isEmailUnique(@PathVariable("email") final String email) throws SQLException {

		logger.debug("ENTERED isEmailUnique for username: " + email);

		final boolean isUnique;

		if (accountService.getAccountByEmail(email) != null) {
			isUnique = false;
		}
		else {
			isUnique = true;
		}

		logger.debug("EXITING isEmailUnique for email: " + email + ", with result: " + isUnique);

		return new ResponseEntity("{\"isUnique\": " + isUnique +"}", HttpStatus.OK);
	}
}
