package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;

public interface CommentService {

	Comment getCommentById(long commentId) throws SQLException;

	Comment getCommentBySubject(SubjectType subjectType, long subjectId) throws SQLException;

	List<Comment> getCommentsByPoster(long posterId) throws SQLException;
}
