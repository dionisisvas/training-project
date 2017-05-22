package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.User;
import com.iri.training.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value= "/user")
	public ResponseEntity<ArrayDeque<User>> getAllUsers() throws SQLException {
		ArrayDeque<User> users = userRepository.getUserArray();
		if (users != null)
		{
			return new ResponseEntity<ArrayDeque<User>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<ArrayDeque<User>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value= "/user/{userId}")
	public ResponseEntity<User> getUserPage(@PathVariable("userId") Long id) throws SQLException {
		User user = userRepository.getUserById(id);
		if (user != null)
		{
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}
