package com.iri.training.model;

public class Hobby {

	private Long hobbyId;
	private String hobbyName;
	private String description;
	private Long userId;


	public Long getUserId() {

		return userId;
	}

	public void setUserId(final Long userId) {

		this.userId = userId;
	}



	public Long getHobbyId() { return hobbyId; }

	public void setHobbyId(final Long hobbyId) { this.hobbyId = hobbyId; }

	public String getHobbyName() { return hobbyName; }

	public void setHobbyName(final String hobbyName) { this.hobbyName = hobbyName; }

	public String getDescription() { return description; }

	public void setDescription(final String description) { this.description = description; }

	@Override public String toString() {

		return "Hobby{" +
			"hobbyId=" + hobbyId +
			", hobbyName='" + hobbyName + '\'' +
			", description='" + description + '\'' +
			", userId=" + userId +
			'}';
	}

}
