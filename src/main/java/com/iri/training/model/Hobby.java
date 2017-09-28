package com.iri.training.model;

public class Hobby {

	private long hobbyId;
	private String name;
	private String description;

	public Long getHobbyId() {

		return hobbyId;
	}

	public void setHobbyId(final long hobbyId) {

		this.hobbyId = hobbyId;
	}

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(final String description) {

		this.description = description;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Hobby{");
		sb.append("hobbyId=");
		sb.append(hobbyId);
		sb.append('\'');
		sb.append(", name='");
		sb.append(name);
		sb.append('\'');
		sb.append(", description='");
		sb.append(description);
		sb.append('\'');
		sb.append('}');

		return sb.toString();
	}
}
