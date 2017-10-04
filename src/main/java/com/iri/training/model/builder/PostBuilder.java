package com.iri.training.model.builder;

import java.time.LocalDateTime;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.Post;

public class PostBuilder extends PostBuilderBase<PostBuilder> {

	public static PostBuilder post() {

		return new PostBuilder();
	}

	public PostBuilder() {

		super(new Post());
	}

	public Post build() {

		return getInstance();
	}
}

class PostBuilderBase<GeneratorT extends PostBuilderBase<GeneratorT>> {

	private final Post instance;

	protected PostBuilderBase(final Post aInstance) {

		instance = aInstance;
	}

	protected Post getInstance() {

		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withId(final long aValue) {

		instance.setId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withPosterId(final long aValue) {

		instance.setPosterId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSubjectType(final SubjectType aValue) {

		instance.setSubjectType(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSubjectId(final long aValue) {

		instance.setSubjectId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withTitle(final String aValue) {

		instance.setTitle(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withContent(final String aValue) {

		instance.setContent(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withCreationDate(final LocalDateTime aValue) {

		instance.setCreationDate(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withLastEditDate(final LocalDateTime aValue) {

		instance.setLastEditDate(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withComments(final List<Comment> aValue) {

		instance.setComments(aValue);

		return (GeneratorT) this;
	}
}
