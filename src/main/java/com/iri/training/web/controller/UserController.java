package com.iri.training.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.User;
import com.iri.training.web.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public User getUserById(final HttpServletRequest request, @PathVariable final Long userId) {

		User user = userService.getUserById(userId);
		
		return user;
	}
	
}
