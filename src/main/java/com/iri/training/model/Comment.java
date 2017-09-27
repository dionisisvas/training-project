package com.iri.training.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.interfaces.IPostable;

public class Comment implements IPostable{

	private long id;
	private long posterId;
	private SubjectType subjectType;
	private long subjectId;
	private String content;
	private LocalDateTime creationDate;
	private LocalDateTime lastEditDate;
	private List<CommentReply> replies;

	public long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
	}

	public long getPosterId() {

		return posterId;
	}

	public void setPosterId(final long posterId) {

		this.posterId = posterId;
	}

	public SubjectType getSubjectType() {

		return subjectType;
	}

	public void setSubjectType(final SubjectType subjectType) {

		this.subjectType = subjectType;
	}

	public long getSubjectId() {

		return subjectId;
	}

	public void setSubjectId(final long subjectId) {

		this.subjectId = subjectId;
	}

	public String getContent() {

		return content;
	}

	public void setContent(final String content) {

		this.content = content;
	}

	public LocalDateTime getCreationDate() {

		return creationDate;
	}

	public void setCreationDate(final LocalDateTime creationDate) {

		this.creationDate = creationDate;
	}

	public LocalDateTime getLastEditDate() {

		return lastEditDate;
	}

	public void setLastEditDate(final LocalDateTime lastEditDate) {

		this.lastEditDate = lastEditDate;
	}

	public List<CommentReply> getReplies() {

		return replies;
	}

	public void setReplies(final List<CommentReply> replies) {

		this.replies = replies;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Comment{");
		sb.append("id=");
		sb.append(id);
		sb.append('\'');
		sb.append(", posterId='");
		sb.append(posterId);
		sb.append('\'');
		sb.append(", subjectType='");
		sb.append(subjectType);
		sb.append('\'');
		sb.append(", subjectId='");
		sb.append(subjectId);
		sb.append('\'');
		sb.append(", content='");
		sb.append(content);
		sb.append('\'');
		sb.append(", creationDate='");
		sb.append(creationDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		sb.append('\'');
		sb.append(", lastEditDate='");
		sb.append(lastEditDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
		sb.append('\'');
		sb.append(", replies='");
		sb.append(replies);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
