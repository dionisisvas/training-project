package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.web.service.CommentReplyService;
import com.iri.training.web.service.CommentService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/comment")
public class CommentController {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CommentService commentService;
	@Autowired
	CommentReplyService replyService;

	@RequestMapping(value = "/{commentId}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getCommentById(
			@PathVariable("commentId") long commentId,
			@RequestParam("getReplies") Optional<Boolean> getReplies) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId);

		final Comment comment = commentService.getCommentById(commentId,
															  getReplies.orElse(false));

		logger.debug("EXITING getCommentById for commentId: " + commentId);

		if (comment != null) {
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}

		return new ResponseEntity<Comment>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/subject/{subjectType}/{subjectId}", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>>  getCommentsBySubject(
			@PathVariable("subjectType")SubjectType subjectType,
			@PathVariable("subjectId") long subjectId,
			@RequestParam("getReplies") Optional<Boolean> getReplies) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
				"with subjectId: " + subjectId);

		final List<Comment> comments = new ArrayList<Comment>(
				commentService.getCommentsBySubject(subjectType,
													subjectId,
													getReplies.orElse(false)));

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId);

		if (comments != null) {
			return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
		}

		return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/poster/{posterId}", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getCommentsByPoster(
				@PathVariable("posterId") long posterId,
				@RequestParam("getReplies") Optional<Boolean> getReplies) throws SQLException {

		logger.debug("ENTERED getCommentsByPoster for posterId: " + posterId);

		final List<Comment> comments = new ArrayList<Comment>(
				commentService.getCommentsByPoster(posterId,
												   getReplies.orElse(false)));

		logger.debug("EXITING getCommentsByPoster for posterId: " + posterId);

		if (comments != null) {
			return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
		}

		return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/reply/{replyId}", method = RequestMethod.GET)
	public ResponseEntity<CommentReply> getReplyById(@PathVariable("replyId") long replyId) throws SQLException {

		logger.debug("ENTERED getReplyById for replyId: " + replyId);

		final CommentReply reply = replyService.getReplyById(replyId);

		logger.debug("EXITING getReplyById for replyId: " + replyId);

		if (reply != null) {
			return new ResponseEntity<CommentReply>(reply, HttpStatus.OK);
		}

		return new ResponseEntity<CommentReply>(HttpStatus.NOT_FOUND);
	}
	@RequestMapping(value = "/{commentId}/replies", method = RequestMethod.GET)
	public ResponseEntity<List<CommentReply>> getCommentReplies(
		@PathVariable("commentId") long commentId) throws SQLException {

		logger.debug("ENTERED getCommentReplies for commentId: " + commentId);

		final List<CommentReply> replies = new ArrayList<CommentReply>(replyService.getCommentReplies(commentId));

		logger.debug("EXITING getCommentsReplies for commentId: " + commentId);

		if (replies != null) {
			return new ResponseEntity<List<CommentReply>>(replies, HttpStatus.OK);
		}

		return new ResponseEntity<List<CommentReply>>(HttpStatus.NOT_FOUND);
	}
}
