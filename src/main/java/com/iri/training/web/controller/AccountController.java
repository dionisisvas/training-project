package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
import com.iri.training.model.User;
import com.iri.training.web.service.AccountService;
import com.iri.training.web.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

	Logger logger = Logger.getLogger(AccountController.class);


	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;

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

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity registerAccount(@RequestBody RegistrationWrapper rw) throws SQLException {
		logger.debug("ENTERED registerAccount: " + rw.getAccount() + rw.getUser());

		accountService.createAccount(rw.getAccount());
		userService.addUser(rw.getUser());

		logger.debug("EXITING registerAccount: " + rw.getAccount() + rw.getUser());

		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authAccount(@RequestBody Account account) throws SQLException {
		logger.debug("ENTERED authAccount");

		if (account.getUsername() == null || account.getPassword() == null) {
			return new ResponseEntity("Insufficient log in data.", HttpStatus.BAD_REQUEST);
		}
		else if (accountService.getAccount(account.getUsername()) == null) {
			return new ResponseEntity("Username does not exist.", HttpStatus.NOT_FOUND);
		}
		else if (accountService.getAccount(account.getUsername()).getPassword() != account.getPassword()) {
			return new ResponseEntity("Invalid log in details.", HttpStatus.BAD_REQUEST);
		}

		String jwt = Jwts.builder().setIssuer("IRI Training App")
			.setSubject(String.valueOf(accountService.getAccount(account.getUsername()).getAccountId()))
			.setIssuedAt(new Date())
			.claim("name", userService.getUserByUsername(account.getUsername()).getName())
			.signWith(SignatureAlgorithm.HS256, "secretkey")
			.compact();

		logger.debug("EXITING authAccount");

		return new ResponseEntity<String>(new StringBuilder(200)
												.append("{\"token\": \"")
												.append(jwt)
												.append("\"}")
											.toString(),
											HttpStatus.OK);
	}

	private static class RegistrationWrapper {

		private Account account;
		private User user;

		public Account getAccount() { return account; }

		public void setAccount(Account account) { this.account = account; }

		public User getUser() { return user; }

		public void setUser(User user) { this.user = user; }
	}
}
