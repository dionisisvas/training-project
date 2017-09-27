package com.iri.training.model;

public class Hobby {

	private long id;
	private String name;
	private String description;

	public Long getId() {

		return id;
	}

	public void setId(final long id) {

		this.id = id;
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
		sb.append("id=");
		sb.append(id);
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
