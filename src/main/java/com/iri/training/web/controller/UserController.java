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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.User;
import com.iri.training.web.service.UserService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/user")
public final class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/uid/{userId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<User> getUserById(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getUserById for userId: " + userId);

		final User user = userService.getUserById(userId);

		logger.debug("EXITING getUserById with user: " + user);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<User> getUserByUsername(@PathVariable("username") final String username) throws SQLException {

		logger.debug("ENTERED getUserByUsername for username: " + username);

		final User user = userService.getUserByUsername(username);

		logger.debug("EXITING getUserByUsername with user: " + user);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<User>> getUserList() throws SQLException {

		logger.debug("ENTERED getUserList");

		final List<User> users = new ArrayList<>(userService.getUserList());

		logger.debug("EXITING getUserList");

		if (users != null) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}

		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	}
}
