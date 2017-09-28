package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Post;
import com.iri.training.repository.CommentRepository;
import com.iri.training.repository.PostRepository;

@Service
public final class PostServiceImpl implements PostService {

	private static final Logger logger = Logger.getLogger(PostService.class);

	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;

	@Override
	public final Post getPostById(final long postId, final boolean getComments) throws SQLException {

		logger.debug("ENTERED getPostById for postId: " + postId +
			" with getComments=" + getComments);

		final Post post;

		if (!getComments) {
			post = postRepository.getPostById(postId);
		}
		else {
			post = postRepository.getPostById(postId);
			post.setComments(commentRepository.getCommentsBySubject(SubjectType.POST, postId));
		}

		logger.debug("EXITING getPostById with post: " + post);

		return post;
	}

	@Override
	public final List<Post> getPostsBySubject(final SubjectType subjectType, final long subjectId, final boolean getComments) throws SQLException {

		logger.debug("ENTERED getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		final List<Post> posts;

		if (!getComments) {
			posts = new ArrayList<Post>(postRepository.getPostsBySubject(subjectType, subjectId));
		}
		else {
			posts = new ArrayList<Post>(postRepository.getPostsBySubject(subjectType, subjectId));
			for(Post post : posts) {
				post.setComments(commentRepository.getCommentsBySubject(SubjectType.POST, post.getId()));
			}
		}

		logger.debug("EXITING getPostsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		return posts;
	}

	@Override
	public final List<Post> getPostsByPoster(final long posterId, final boolean getComments) throws SQLException {

		logger.debug("ENTERED getPostByPoster for posterId: " + posterId +
			" with getComments=" + getComments);

		final List<Post> posts;

		if (!getComments) {
			posts = new ArrayList<Post>(postRepository.getPostsByPoster(posterId));
		}
		else {
			posts = new ArrayList<Post>(postRepository.getPostsByPoster(posterId));
			for(Post post : posts) {
				post.setComments(commentRepository.getCommentsBySubject(SubjectType.POST, post.getId()));
			}
		}

		logger.debug("EXITING getPostByPoster for posterId: " + posterId +
			" with getComments=" + getComments);

		return posts;
	}
}
