package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;

public interface CommentRepository {

	Comment getCommentById(long commentId) throws SQLException;

	List<Comment> getCommentsBySubject(SubjectType subjectType, long subjectId) throws SQLException;

	void addComment(Comment comment) throws SQLException;

	void deleteComment(long commentId) throws  SQLException;

	void deleteCommentReplies(SubjectType subjectType, long parentId) throws SQLException;

	void editComment(Comment comment) throws SQLException;
}
