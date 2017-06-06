package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = "create/{user}", method = RequestMethod.GET)
	public void createUser(final HttpServletRequest request, @PathVariable("user") User user) throws SQLException {

		logger.debug("ENTERED createUser");

		userService.createUser(user);

		logger.debug("EXITING createUser " + user);
	}

	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public User getUserById(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException {


		logger.debug("ENTERED getUserById: " + userId);

		User user = userService.getUserById(userId);

		logger.debug("EXITING getUserById " + user);

		return user;
	}

}
