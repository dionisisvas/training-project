package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayDeque;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.User;
import com.iri.training.web.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;
	User user;

	@RequestMapping(value = "create/{user}", method = RequestMethod.GET)
	public void createUser(final HttpServletRequest request, @PathVariable("user") User user) throws SQLException {

		logger.debug("ENTERED createUser" + user.toString());

		userService.createUser(user);

		logger.debug("EXITING createUser " + user.toString());
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayDeque<User>> getAllUsers() throws SQLException {

		logger.debug("ENTERED getAllUsers");

		ArrayDeque<User> users = userService.getUserArray();
		if (users != null) {
			return new ResponseEntity<ArrayDeque<User>>(users, HttpStatus.OK);
		}

		logger.debug("EXITING getAllUsers");

		return new ResponseEntity<ArrayDeque<User>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserPage(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getUserById");

		User user = userService.getUserById(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		logger.debug("EXITING getUserPage " + user.toString());

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}
