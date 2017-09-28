package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;

public interface CommentService {

	Comment getCommentById(long commentId, boolean getComments) throws SQLException;

	List<Comment> getCommentsBySubject(SubjectType subjectType, long subjectId, boolean getComments) throws SQLException;
}
