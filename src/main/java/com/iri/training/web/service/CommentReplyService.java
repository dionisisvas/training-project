package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.CommentReply;

public interface CommentReplyService {

	CommentReply getReplyById(long replyId) throws SQLException;

	List<CommentReply> getCommentReplies(long parentId) throws SQLException;
}
