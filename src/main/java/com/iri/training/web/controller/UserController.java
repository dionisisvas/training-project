package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

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

	@Autowired
	UserService userService;
	User user;
	@RequestMapping(value = "create/{user}", method = RequestMethod.GET)
	public void createUser(final HttpServletRequest request, @PathVariable("user") User user)throws SQLException{


		user.getName(request.getParameter("name"));
		user.getSurname(request.getParameter("surname"));
		user.getUsername(request.getParameter("commentID"));
		user.getPassword(request.getParameter("userID"));
		user=userService.createUser(user);

	}

	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public User getUserById(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException {
		user = userService.getUserById(userId);
		return user;
	}

}
