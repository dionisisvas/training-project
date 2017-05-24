
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
@RequestMapping("/userComment")
public class UserCommentController{

	@Autowired
	UserCommentService userCommentService;
	UserComment userComment;
	@RequestMapping(value = "create/{userComment}", method = RequestMethod.GET)
	public void createUserComment(final HttpServletRequest request, @PathVariable("userComment") UserComment userComment)throws SQLException{

		userComment=userCommentService.createUserComment(userComment);

	}


	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public UserComment getUserCommentById(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException, ClassNotFoundException {

		 userComment = userCommentService.getUserCommentById(userId);

		return userComment;
	}

}