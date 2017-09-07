package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.CommentReply;
import com.iri.training.repository.CommentReplyRepository;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CommentReplyRepository replyRepository;

	@Override
	public CommentReply getReplyById(long replyId) throws SQLException {

		return replyRepository.getReplyById(replyId);
	}

	@Override
	public List<CommentReply> getCommentReplies(long parentId) throws SQLException{

		return new ArrayList<CommentReply>(replyRepository.getCommentReplies(parentId));
	}
}
