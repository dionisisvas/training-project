package com.iri.training.model;

import java.time.LocalDateTime;

import com.iri.training.model.interfaces.IPostable;

public class CommentReply implements IPostable{

	private long id;
	private long posterId;
	private long parentId;
	private String content;
	private LocalDateTime creationDate;
	private LocalDateTime lastEditDate;

	public long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
	}

	@Override public long getPosterId() {

		return posterId;
	}

	public void setPosterId(final long posterId) {

		this.posterId = posterId;
	}

	public long getParentId() {

		return parentId;
	}

	public void setParentId(final long parentId) {

		this.parentId = parentId;
	}

	@Override public String getContent() {

		return content;
	}

	public void setContent(final String content) {

		this.content = content;
	}

	@Override public LocalDateTime getCreationDate() {

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

		return "CommentReply{" +
			"id=" + id +
			", posterId=" + posterId +
			", parentId=" + parentId +
			", content='" + content + '\'' +
			", creationDate=" + creationDate +
			", lastEditDate=" + lastEditDate +
			'}';
	}
}
