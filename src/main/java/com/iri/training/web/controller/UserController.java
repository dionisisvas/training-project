package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepositoryImpl;
import com.iri.training.web.service.UserService;



public class UserController {
	@RequestMapping(value = "/rest/user")
	public class UsersResource {

		@Autowired
		UserRepositoryImpl userCache;

		@RequestMapping(value = "/{userId}")
		public User getUser(@PathVariable final Long userId) throws SQLException {

			return userCache.findUserById(userId);
		}
	}
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

	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public User getUserById(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException {


		logger.debug("ENTERED getUserById" + user.toString());

		user = userService.getUserById(userId);

		logger.debug("EXITING getUserById " + user.toString());

		return user;
	}

}
