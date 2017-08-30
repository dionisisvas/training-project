package com.iri.training.web.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.web.service.CommentService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/comment/")
public class CommentController {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getCommentById(@PathVariable("commentId") long commentId) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId);

		Comment comment = commentService.getCommentById(commentId);

		logger.debug("EXITING getCommentById for commentId: " + commentId);

		if (comment != null) {
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}

		return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/subject/{subjectType}#{subjectId}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getCommentBySubject(
			@PathVariable("subjectType")SubjectType subjectType,
			@PathVariable("subjectId") long subjectId) throws SQLException {

		logger.debug("ENTERED getCommentBySubject for subjectType: " + subjectType +
				"with subjectId: " + subjectId);

		Comment comment = commentService.getCommentBySubject(subjectType, subjectId);

		logger.debug("EXITING getCommentBySubject for subjectType: " + subjectType +
			"with subjectId: " + subjectId);

		if (comment != null) {
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}

		return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/poster/{posterId}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getCommentByPoster(@PathVariable("posterId") long posterId) throws SQLException {

		logger.debug("ENTERED getCommentByPoster for posterId: " + posterID);

		Comment comment = commentService.getCommentByPoster(posterId);

		logger.debug("EXITING getCommentByPoster for posterId: " + posterID);

		if (comment != null) {
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}

		return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}
}