package com.iri.training.web.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.iri.training.model.User;
import com.iri.training.web.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ModelAndView getUserPage(@PathVariable final Long userId) throws SQLException {
		StringBuilder fullName = new StringBuilder().append(getUserById(userId));

		ModelAndView model = new ModelAndView();
		model.setViewName("user-page");
		model.addObject("full_name", fullName);

		return model;
    }

	private User getUserById(final Long userId) throws SQLException {
		User user = userService.getUserById(userId);

		return user;
	}
}
