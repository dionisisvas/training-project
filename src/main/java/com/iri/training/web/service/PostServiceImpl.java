package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Post;
import com.iri.training.repository.PostRepository;

@Service
public final class PostServiceImpl implements PostService {

	private static final Logger logger = Logger.getLogger(PostService.class);

	@Autowired
	CommentService commentService;
	@Autowired
	PostRepository postRepository;

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
			post.setComments(commentService.getCommentsBySubject(SubjectType.POST, postId, false));
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
				post.setComments(commentService.getCommentsBySubject(SubjectType.POST, post.getId(), false));
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
				post.setComments(commentService.getCommentsBySubject(SubjectType.POST, post.getId(), false));
			}
		}

		logger.debug("EXITING getPostByPoster for posterId: " + posterId +
			" with getComments=" + getComments);

		return posts;
	}

	@Override
	public final Post addPost(final Post post) throws SQLException {

		logger.debug("ENTERED addPost for post: " + post);

		final long postId = postRepository.addPostAndGetGeneratedId(post);

		logger.debug("EXITING addPost for post: " + post);

		return getPostById(postId, true);
	}

	@Override
	public final void deletePost(final long postId) throws SQLException {

		logger.debug("ENTERED deletePost for postId: " + postId);

		commentService.deleteCommentReplies(SubjectType.POST, postId);
		postRepository.deletePost(postId);

		logger.debug("EXITING deletePost for postId: " + postId);
	}

	@Override
	public final void editPost(final Post post) throws SQLException {

		logger.debug("ENTERED editPost for post: " + post);

		postRepository.editPost(post);

		logger.debug("EXITING editPost for post: " + post);
	}
}
