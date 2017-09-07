package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.CommentReply;

public interface CommentReplyRepository {

	CommentReply getReplyById(long replyId) throws SQLException;

	List<CommentReply> getCommentReplies(long parentId) throws SQLException;
}
