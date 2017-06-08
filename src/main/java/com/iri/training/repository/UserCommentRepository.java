package com.iri.training.repository;

import java.sql.SQLException;

import com.iri.training.model.UserComment;

public interface UserCommentRepository {
	UserComment getCommentsByUserId(Long userId) throws SQLException;
	UserComment createUserComment(UserComment userComment) throws SQLException;
}
