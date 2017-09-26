package com.iri.training.web.controller;

import java.sql.SQLException;
import java.time.ZoneOffset;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.Account;
import com.iri.training.model.User;
import com.iri.training.web.service.AccountService;
import com.iri.training.web.service.MetricsService;
import com.iri.training.web.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

	private static final Logger logger = Logger.getLogger(AuthController.class);

	@Autowired
	AccountService accountService;
	@Autowired
	MetricsService metricsService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> addAccountAndUser(@RequestBody final RegistrationWrapper rw) throws SQLException {

		final Account account = rw.getAccount();
		final User user = rw.getUser();

		logger.debug("ENTERED addAccountAndUser for account: " + account +
			" and user: " + user);

		if ( accountService.verifyNewAccount(account) &&
				userService.verifyNewUser(user)) {

			final long userId = userService.addUserAndGetGeneratedId(user);

			account.setId(userId);
			accountService.addAccount(account);
			metricsService.initializeUserMetrics(userId);

			logger.debug("EXITING addAccountAndUser for id: " + userId);

			return new ResponseEntity("{\"message\": \"Registration success.\"}", HttpStatus.OK);
		}
		else {
			logger.debug("EXITING addAccountAndUser - Registration failed");

			return new ResponseEntity("{\"message\": \"Registration failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> authLogin(@RequestBody final Account account) throws SQLException {

		logger.debug("ENTERED authLogin for account: " + account);

		final User user = userService.getUserByUsername(account.getUsername());

		if (account.getUsername() == null || account.getPassword() == null) {
			logger.debug("EXITING authLogin for account: " + account +
			 " with insufficient log in data failure");

			return new ResponseEntity("{\"message\": \"Insufficient log in data.\"}", HttpStatus.BAD_REQUEST);
		}
		else if (accountService.getAccountByUsername(account.getUsername()) == null) {
			logger.debug("EXITING authLogin for account: " + account +
				" with nonexistent username failure");

			return new ResponseEntity("{\"message\": \"Username does not exist.\"}", HttpStatus.BAD_REQUEST);
		}
		else if (!accountService.getAccountByUsername(account.getUsername()).getPassword().equals(account.getPassword())) {
			logger.debug("EXITING authLogin for account: " + account +
				" with invalid log in details failure");

			return new ResponseEntity("{\"message\": \"Invalid log in details.\"}", HttpStatus.BAD_REQUEST);
		}

		final String jwt = Jwts.builder().setIssuer("IRI Training App")
			.setSubject(String.valueOf(accountService.getAccountByUsername(account.getUsername()).getId()))
			.setIssuedAt(new Date())
			.setExpiration(Date.from((PropertiesConfig.KEY_EXPIRY_DATE).toInstant(ZoneOffset.UTC)))
			.claim("name", user.getName())
			.claim("surname", user.getSurname())
			.claim("username", account.getUsername())
			.claim("email", accountService.getAccountByUsername(account.getUsername()).getEmail())
			.signWith(SignatureAlgorithm.HS256, PropertiesConfig.JWT_KEY)
			.compact();

		logger.debug("EXITING authLogin for account" + account +
			" with JSON Web Token: " + jwt);

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

		private Account getAccount() { return account; }

		private void setAccount(Account account) { this.account = account; }

		private User getUser() { return user; }

		private void setUser(User user) { this.user = user; }
	}
}
