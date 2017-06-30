package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;

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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createAccount(@RequestBody Account account) throws SQLException {
		logger.debug("ENTERED createAccount: " + account);

		accountService.createAccount(account);

		logger.debug("EXITING createAccount: " + account);

		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String authAccount(@RequestBody Account account) throws SQLException, ServletException {
		logger.debug("ENTERED authAccount");

		if ((account.getUsername() == null && account.getEmail() == null)
			|| account.getPassword() == null) {
			throw new ServletException("Insufficient login data.");
		}
		else if ((accountService.getAccountByEmail(account.getEmail()) == null)
				&& accountService.getAccount(account.getUsername()) == null) {
			throw new SQLException("Account doesn't exist.");
		}
		else
		{
			// pwd verification here
		}

		StringBuilder sb = new StringBuilder();
		sb.append("accountId/");
		sb.append(accountService.getAccount(account.getUsername()).getAccountId());

		logger.debug("EXITING authAccount");

		return Jwts.builder().setIssuer("IRI Training App")
			.setSubject(sb.toString())
			.setIssuedAt(new Date())
			.signWith(SignatureAlgorithm.HS256, "secretkey")
			.compact();
	}
}
