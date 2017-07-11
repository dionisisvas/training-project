package com.iri.training.model;

public class Hobby {

	private Long hobbyId;
	private String hobbyName;
	private String description;

	public Long getHobbyId() { return hobbyId; }

	public void setHobbyId(final Long hobbyId) { this.hobbyId = hobbyId; }

	public String getHobbyName() { return hobbyName; }

	public void setHobbyName(final String hobbyName) { this.hobbyName = hobbyName; }

	public String getDescription() { return description; }

	public void setDescription(final String description) { this.description = description; }

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Hobby{");
		sb.append("hobbyId=");
		sb.append(hobbyId);
		sb.append('\'');
		sb.append(", hobbyName='");
		sb.append(hobbyName);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
