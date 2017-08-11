package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.UserComment;
import com.iri.training.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
	Logger logger = Logger.getLogger(CommentServiceImpl.class);
	@Autowired
	CommentRepository userCommentRepository;

	@Override

	public List<UserComment> getCommentsByUserId(Long userId) throws SQLException {
		logger.debug("ENTERED getCommentsByUserId: " + userId);
		List<UserComment> userComment=userCommentRepository.getCommentsByUserId(userId);
		logger.debug("EXITING getCommentsByUserId " + userComment);
		return userComment;



	}

	@Override
	public UserComment createUserComment(UserComment userComment) throws SQLException {
		logger.debug("ENTERED createUserComment: " + userComment);
		userCommentRepository.createUserComment(userComment);
		logger.debug("EXITING createUserComment: " + userComment);
		return userComment;

	}
}