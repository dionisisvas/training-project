package com.iri.training.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.UserComment;
import com.iri.training.repository.UserCommentRepository;

@Service
public class UserCommentServiceImpl implements UserCommentService {
	@Autowired
	UserCommentRepository userCommentRepository;

	@Override
	public UserComment getUserCommentById(Long userId) throws SQLException {

		userCommentRepository.getUserCommentById(userId);

		return null;

	}

	@Override
	public UserComment createUserComment(UserComment userComment) throws SQLException {

		userCommentRepository.createUserComment(userComment);
		return userComment;

	}
	}
