package com.iri.training.model.builder;

import java.time.LocalDateTime;
import java.util.List;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;
import com.iri.training.model.CommentReply;

public class CommentBuilder extends CommentBuilderBase<CommentBuilder> {

	public static CommentBuilder comment() {

		return new CommentBuilder();
	}

	public CommentBuilder() {

		super(new Comment());
	}

	public Comment build() {

		return getInstance();
	}
}

class CommentBuilderBase<GeneratorT extends CommentBuilderBase<GeneratorT>> {

	private final Comment instance;

	protected CommentBuilderBase(final Comment aInstance) {

		instance = aInstance;
	}

	protected Comment getInstance() {

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
	public GeneratorT withReplies(final List<CommentReply> aValue) {

		instance.setReplies(aValue);

		return (GeneratorT) this;
	}
}
