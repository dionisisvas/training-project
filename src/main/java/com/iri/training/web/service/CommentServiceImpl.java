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
			"with subjectId: " + subjectId);

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
			"with subjectId: " + subjectId);

		return comments;
	}
}
