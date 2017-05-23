package com.iri.training.repository;

import java.sql.SQLException;

import com.iri.training.model.UserComment;

public interface UserCommentRepository {
	UserComment getUserCommentById(Long userId) throws SQLException;
	UserComment CreateUserComment(String description,String comdate,int commID,int useID)throws SQLException;
}
