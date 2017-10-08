package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.repository.CommentRepository;

@Service
public final class CommentServiceImpl implements CommentService {

	private static final Logger logger = Logger.getLogger(CommentService.class);

	@Autowired
	CommentRepository commentRepository;

	@Override
	public final Comment getCommentById(final long commentId, final boolean getComments) throws SQLException {

		logger.debug("ENTERED getCommentById for commentId: " + commentId +
			" with getComments=" + getComments);

		final Comment comment;

		if (!getComments) {
			comment = commentRepository.getCommentById(commentId);
		}
		else {
			comment = commentRepository.getCommentById(commentId);
			comment.setComments(commentRepository.getCommentsBySubject(SubjectType.COMMENT, commentId));

			return comment;
		}

		logger.debug("EXITING getCommentById with comment: " + comment);

		return comment;
	}

	@Override
	public final List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId, final boolean getComments) throws SQLException {

		logger.debug("ENTERED getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		final List<Comment> comments;

		if (!getComments) {
			comments = new ArrayList<Comment>(commentRepository.getCommentsBySubject(subjectType, subjectId));
		}
		else {
			comments = new ArrayList<Comment>(commentRepository.getCommentsBySubject(subjectType, subjectId));
			for(Comment comment : comments) {
				comment.setComments(commentRepository.getCommentsBySubject(SubjectType.COMMENT, comment.getId()));
			}
		}

		logger.debug("EXITING getCommentsBySubject for subjectType: " + subjectType +
			" with subjectId: " + subjectId +
			" with getComments=" + getComments);

		return comments;
	}

	@Override
	public final void addComment(final Comment comment) throws SQLException {

		logger.debug("ENTERED addComment for comment: " + comment);

		commentRepository.addComment(comment);

		logger.debug("EXITING addComment for comment: " + comment);
	}

	@Override
	public final void deleteComment(final long commentId) throws SQLException {

		logger.debug("ENTERED deleteComment for commentId: " + commentId);

		deleteCommentReplies(SubjectType.COMMENT, commentId);
		commentRepository.deleteComment(commentId);

		logger.debug("EXITING deleteComment for commentId: " + commentId);
	}

	@Override
	public final void deleteCommentReplies(final SubjectType subjectType, final long parentId) throws SQLException {

		logger.debug("ENTERED deleteCommentReplies for " + subjectType + " with id: " + parentId);

		commentRepository.deleteCommentReplies(subjectType, parentId);

		logger.debug("EXITING deleteCommentReplies for " + subjectType + " with id: " + parentId);
	}

	@Override
	public Comment editComment(final Comment comment) throws SQLException {

		logger.debug("ENTERED editComment for comment: " + comment);

		commentRepository.editComment(comment);

		logger.debug("EXITING editComment for comment: " + comment);

		return getCommentById(comment.getId(), false);
	}
}
