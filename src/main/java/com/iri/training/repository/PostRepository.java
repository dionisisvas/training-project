package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Post;

public interface PostRepository {

	Post getPostById(long postId) throws SQLException;

	List<Post> getPostsBySubject(SubjectType subjectType, long subjectId) throws SQLException;

	List<Post> getPostsByPoster(long posterId) throws SQLException;

	void addPost(Post post) throws SQLException;

	void deletePost(long postId) throws  SQLException;

	void editPost(Post post) throws SQLException;
}
