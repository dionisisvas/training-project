package com.iri.training.model;

import java.time.LocalDateTime;
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
	private List<Comment> comments;

	@Override
	public long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
	}

	@Override
	public long getPosterId() {

		return posterId;
	}

	public void setPosterId(final long posterId) {

		this.posterId = posterId;
	}

	@Override
	public SubjectType getSubjectType() {

		return subjectType;
	}

	public void setSubjectType(final SubjectType subjectType) {

		this.subjectType = subjectType;
	}

	@Override
	public long getSubjectId() {

		return subjectId;
	}

	public void setSubjectId(final long subjectId) {

		this.subjectId = subjectId;
	}

	@Override
	public String getContent() {

		return content;
	}

	public void setContent(final String content) {

		this.content = content;
	}

	@Override
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

	public List<Comment> getComments() {

		return comments;
	}

	public void setComments(final List<Comment> replies) {

		this.comments = replies;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder();

		sb.append("Comment{");
		sb.append("id=").append(id);
		sb.append(", posterId=").append(posterId);
		sb.append(", subjectType=").append(subjectType);
		sb.append(", subjectId=").append(subjectId);
		sb.append(", content='").append(content).append('\'');
		sb.append(", creationDate=").append(creationDate);
		sb.append(", lastEditDate=").append(lastEditDate);
		sb.append(", comments=").append(comments);
		sb.append('}');

		return sb.toString();
	}
}
