
package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.UserComment;
import com.iri.training.web.service.UserCommentService;

@RestController
@RequestMapping("/user")
public class UserCommentController{

	@Autowired
	UserCommentService userCommentService;

	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public UserComment getUserById(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException {

		UserComment userComment = userCommentService.getUserCommentById(userId);

		return userComment;
	}

}