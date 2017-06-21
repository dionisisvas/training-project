package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.UserComment;

public interface CommentRepository {
	List<UserComment> getCommentsByUserId(Long userId) throws SQLException;
	UserComment createUserComment(UserComment userComment) throws SQLException;
}
