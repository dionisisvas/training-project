package com.iri.training.model;

import java.time.LocalDateTime;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.interfaces.IPostable;

public class Post implements IPostable{

	private long id;
	private long posterId;
	private SubjectType subjectType;
	private long subjectId;
	private String title;
	private String content;
	private LocalDateTime creationDate;
	private LocalDateTime lastEditDate;
	private List<Comment> comments;

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

	public void setComments(final List<Comment> comments) {

		this.comments = comments;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder();

		sb.append("Post{");
		sb.append("id=").append(id);
		sb.append(", posterId=").append(posterId);
		sb.append(", subjectType=").append(subjectType);
		sb.append(", subjectId=").append(subjectId);
		sb.append(", title='").append(title).append('\'');
		sb.append(", content='").append(content).append('\'');
		sb.append(", creationDate=").append(creationDate);
		sb.append(", lastEditDate=").append(lastEditDate);
		sb.append(", comments=").append(comments);
		sb.append('}');

		return sb.toString();
	}
}
