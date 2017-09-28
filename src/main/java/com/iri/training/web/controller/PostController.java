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
import com.iri.training.model.Post;
import com.iri.training.web.service.CommentService;
import com.iri.training.web.service.PostService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/post")
public final class PostController {

	private static final Logger logger = Logger.getLogger(PostController.class);

	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/{postId}", method = RequestMethod.GET)
	public final ResponseEntity<Post> getPostById(
			@PathVariable("postId") final long postId,
			@RequestParam("getComments") final Optional<Boolean> getComments) throws SQLException {

		logger.debug("ENTERED getPostById for postId: " + postId +
			" with getComments=" + getComments);;

		final Post post = postService.getPostById(postId, getComments.orElse(false));

		logger.debug("EXITING getPostById for postId: " + postId +
			"with getComments=" + getComments);

		if (post != null) {
			return new ResponseEntity<Post>(post, HttpStatus.OK);
		}

		return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/subject/{subjectType}/{subjectId}", method = RequestMethod.GET)
	public final ResponseEntity<List<Post>>  getPostsBySubject(
			@PathVariable("subjectType") final SubjectType subjectType,
			@PathVariable("subjectId") final long subjectId,
			@RequestParam("getComments") final Optional<Boolean> getComments) throws SQLException {

		logger.debug("ENTERED getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		final List<Post> posts = new ArrayList<Post>(
			postService.getPostsBySubject(subjectType, subjectId, getComments.orElse(false)));


		logger.debug("EXITING getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		if (posts != null) {
			return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
		}

		return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/poster/{posterId}", method = RequestMethod.GET)
	public final ResponseEntity<List<Post>> getPostsByPoster(
				@PathVariable("posterId") final long posterId,
				@RequestParam("getComments") final Optional<Boolean> getComments) throws SQLException {

		logger.debug("ENTERED getPostByPoster for posterId: " + posterId +
			" with getComments=" + getComments);

		final List<Post> posts = new ArrayList<Post>(
			postService.getPostsByPoster(posterId, getComments.orElse(false)));

		logger.debug("EXITING getPostByPoster for posterId: " + posterId +
			" with getComments=" + getComments);

		if (posts != null) {
			return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
		}

		return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
	}
}
