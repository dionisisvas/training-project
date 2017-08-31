package com.iri.training.model;

import java.time.LocalDateTime;

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

	@Override public String toString() {

		return "Comment{" +
			"id=" + id +
			", posterId=" + posterId +
			", subjectType=" + subjectType +
			", subjectId=" + subjectId +
			", content='" + content + '\'' +
			", creationDate=" + creationDate +
			", lastEditDate=" + lastEditDate +
			'}';
	}
}
