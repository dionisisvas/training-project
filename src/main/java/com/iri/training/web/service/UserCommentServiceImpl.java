package com.iri.training.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.iri.training.model.UserComment;
import com.iri.training.repository.UserCommentRepository;


public class UserCommentServiceImpl {
	@Autowired
	UserCommentRepository userCommentRepository;

	//@Override
	public UserComment getUserCommentById(Long userId) throws SQLException {

		//implement code
		return null;
	}

	}
