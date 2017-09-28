package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Post;

public interface PostService {

	Post getPostById(long postId, boolean getReplies) throws SQLException;

	List<Post> getPostsBySubject(SubjectType subjectType, long subjectId, boolean getReplies) throws SQLException;

	List<Post> getPostsByPoster(long posterId, boolean getReplies) throws SQLException;
}
