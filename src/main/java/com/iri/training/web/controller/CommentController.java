package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.web.service.AuthService;
import com.iri.training.web.service.CommentService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/comment")
public final class CommentController {

	private static final Logger logger = Logger.getLogger(CommentController.class);

	@Autowired
	AuthService authService;
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public final ResponseEntity<Comment> getCommentById(
			@PathVariable("commentId") final long commentId,
			@RequestParam("getComments") final Optional<Boolean> getComments) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId +
			" with getComments=" + getComments);

		final Comment comment = commentService.getCommentById(commentId, getComments.orElse(false));

		logger.debug("EXITING getCommentById with comment: " + comment);

		if (comment != null) {
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}

		return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/subject/{subjectType}/{subjectId}", method = RequestMethod.GET)
	public final ResponseEntity<List<Comment>>  getCommentsBySubject(
			@PathVariable("subjectType") final SubjectType subjectType,
			@PathVariable("subjectId") final long subjectId,
			@RequestParam("getComments") final Optional<Boolean> getComments) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		final List<Comment> comments = new ArrayList<Comment>(
			commentService.getCommentsBySubject(subjectType, subjectId, getComments.orElse(false)));

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		if (comments != null) {
			return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
		}

		return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> addComment(@RequestHeader(value="Authorization") final String authHeader,
		@RequestBody final Comment comment) throws SQLException {

		logger.debug("ENTERED addComment for comment: " + comment);
		if (authService.verifyAddRights(comment, authHeader)) {
			commentService.addComment(comment);

			logger.debug("EXITING addComment for comment: " + comment + ". Comment added successfully.");

			return new ResponseEntity("{\"message\": \"Comment added successfully.\"}", HttpStatus.OK);
		}
		else {
			logger.debug("EXITING addComment for comment: " + comment + ". Comment posting failed.");

			return new ResponseEntity("{\"message\": \"Comment posting failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{commentId}/delete", method = RequestMethod.DELETE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> deleteComment(@RequestHeader(value="Authorization") final String authHeader,
		@PathVariable("commentId") final long commentId) throws SQLException {

		logger.debug("ENTERED deleteComment for commentId: " + commentId);

		if (authService.verifyDeleteRights(SubjectType.COMMENT, commentId, authHeader)) {
			commentService.deleteComment(commentId);

			logger.debug("EXITING deleteComment for commentId: " + commentId + ". Delete success.");

			return new ResponseEntity("{\"message\": \"Comment deleted successfully.\"}", HttpStatus.OK);
		}
		else {
			logger.debug("EXITING deleteComment for commentId: " + commentId + ". Delete failed.");

			return new ResponseEntity("{\"message\": \"Comment deletion failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT,
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<String> editComment(@RequestHeader(value="Authorization") final String authHeader,
		@RequestBody final Comment comment) throws SQLException {

		logger.debug("ENTERED editComment for comment: " + comment);
		if (authService.verifyEditRights(comment, authHeader)) {
			commentService.editComment(comment);

			logger.debug("EXITING editComment for comment: " + comment + ". Comment edited successfully.");

			return new ResponseEntity("{\"message\": \"Comment edited successfully.\"}", HttpStatus.OK);
		}
		else {
			logger.debug("EXITING editComment for comment: " + comment + ". Comment editing failed.");

			return new ResponseEntity("{\"message\": \"Comment editing failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}
}
