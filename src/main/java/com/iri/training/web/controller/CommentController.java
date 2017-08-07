
package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.UserComment;
import com.iri.training.web.service.CommentService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/userComment")
public class CommentController {
	Logger logger = Logger.getLogger(CommentController.class);
	@Autowired
	CommentService userCommentService;
	@RequestMapping(value = "create/{userComment}", method = RequestMethod.GET)
	public void createUserComment(final HttpServletRequest request, @PathVariable("userComment") UserComment userComment)throws SQLException{

		logger.debug("ENTERED createUserComment for commentId: " + userComment.getCommentID());

		userCommentService.createUserComment(userComment);

		logger.debug("EXITING createUserComment for commentId: " + userComment.getCommentID());
	}



	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public List<UserComment> getCommentsByUserId(final HttpServletRequest request, @PathVariable final Long userId) throws SQLException {


		logger.debug("ENTERED getCommentsByUserId for userId: " + userId);

		List<UserComment> userComment = userCommentService.getCommentsByUserId(userId);

		logger.debug("EXITING getCommentsByUserId for userId: " + userId);


		return userComment;
	}
}