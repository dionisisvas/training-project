package com.iri.training.repository;

import com.iri.training.model.UserComment;

public interface UserCommentRepository {
	UserComment getUserCommentById(Long userId);
	UserComment createUserComment(UserComment userComment);
}
