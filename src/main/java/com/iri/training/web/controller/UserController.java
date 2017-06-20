package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.iri.training.model.User;
import com.iri.training.web.service.UserService;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	Logger logger = Logger.getLogger(UserController.class);


		@Autowired
	UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createUser(@RequestBody User user) throws SQLException {

		logger.debug("ENTERED createUser: "+user);

		userService.createUser(user);

		logger.debug("EXITING createUser " + user);
		return new ResponseEntity( HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<User>> getAllUsers() throws SQLException {

		logger.debug("ENTERED getAllUsers");

		ArrayList<User> users = (ArrayList) userService.getUserList();
		if (users != null) {
			return new ResponseEntity<ArrayList<User>>(users, HttpStatus.OK);
		}

		logger.debug("EXITING getAllUsers");

		return new ResponseEntity<ArrayList<User>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserPage(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getUserById: "+ userId);

		User user = userService.getUserById(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		logger.debug("EXITING getUserPage " + user);

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}
