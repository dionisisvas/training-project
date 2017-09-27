package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.repository.CommentReplyRepository;
import com.iri.training.repository.CommentRepository;

@Service
public final class CommentServiceImpl implements CommentService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	CommentReplyRepository replyRepository;

	@Override
	public Comment getCommentById(final long commentId, final boolean getReplies) throws SQLException {

		if (!getReplies) {
			return commentRepository.getCommentById(commentId);
		}
		else {
			Comment comment = commentRepository.getCommentById(commentId);
			comment.setReplies(replyRepository.getCommentReplies(commentId));

			return comment;
		}
	}

	@Override
	public List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId, boolean getReplies) throws SQLException {

		if (!getReplies) {
			return new ArrayList<Comment>(commentRepository.getCommentsBySubject(subjectType, subjectId));
		}
		else {
			List<Comment> comments = new ArrayList<Comment>(commentRepository.getCommentsBySubject(subjectType, subjectId));
			for(Comment comment : comments) {
				comment.setReplies(replyRepository.getCommentReplies(comment.getId()));
			}

			return comments;
		}
	}

	@Override
	public List<Comment> getCommentsByPoster(final long posterId, boolean getReplies) throws SQLException {

		if (!getReplies) {
			return new ArrayList<Comment>(commentRepository.getCommentsByPoster(posterId));
		}
		else {
			List<Comment> comments = new ArrayList<Comment>(commentRepository.getCommentsByPoster(posterId));
			for(Comment comment : comments) {
				comment.setReplies(replyRepository.getCommentReplies(comment.getId()));
			}

			return comments;
		}
	}
}
