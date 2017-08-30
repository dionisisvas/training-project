package com.iri.training.model;

import java.time.LocalDate;

import com.iri.training.enums.SubjectType;

public class Comment {

	private long commentId;
	private long posterId;
	private SubjectType subjectType;
	private long subjectId;
	private String title;
	private String content;
	private LocalDate creationDate;
	private LocalDate lastEditDate;

	public long getCommentId() {

		return commentId;
	}

	public void setCommentId(final long commentId) {

		this.commentId = commentId;
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

	public String getTitle() {

		return title;
	}

	public void setTitle(final String title) {

		this.title = title;
	}

	public String getContent() {

		return content;
	}

	public void setContent(final String content) {

		this.content = content;
	}

	public LocalDate getCreationDate() {

		return creationDate;
	}

	public void setCreationDate(final LocalDate creationDate) {

		this.creationDate = creationDate;
	}

	public LocalDate getLastEditDate() {

		return lastEditDate;
	}

	public void setLastEditDate(final LocalDate lastEditDate) {

		this.lastEditDate = lastEditDate;
	}

	@Override public String toString() {

		return "Comment{" +
			"commentId=" + commentId +
			", posterId=" + posterId +
			", subjectType=" + subjectType +
			", subjectId=" + subjectId +
			", title='" + title + '\'' +
			", content='" + content + '\'' +
			", creationDate=" + creationDate +
			", lastEditDate=" + lastEditDate +
			'}';
	}
}
