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
public class CommentServiceImpl implements CommentService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment getCommentById(final long commentId) throws SQLException {

		return commentRepository.getCommentById(commentId);
	}

	@Override
	public List<Comment> getCommentsBySubject(final SubjectType subjectType, final long subjectId) throws SQLException {

		return new ArrayList<Comment>(commentRepository.getCommentsBySubject(subjectType, subjectId));
	}

	@Override
	public List<Comment> getCommentsByPoster(final long posterId) throws SQLException {

		return new ArrayList<Comment>(commentRepository.getCommentsByPoster(posterId));
	}
}
