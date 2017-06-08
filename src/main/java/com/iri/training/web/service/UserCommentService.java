package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.UserComment;

public interface UserCommentService {

		List<UserComment> getCommentsByUserId(Long userId) throws SQLException;
		UserComment createUserComment(UserComment userComment) throws SQLException;
	}