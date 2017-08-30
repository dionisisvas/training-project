package com.iri.training.model.builder;

import java.time.LocalDate;

import com.iri.training.enums.SubjectType;
import com.iri.training.model.Comment;

public class CommentBuilder extends CommentBuilderBase<CommentBuilder> {

	public static CommentBuilder comment() {

		return new CommentBuilder();
	}

	public  CommentBuilder() {

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
	public GeneratorT withCommentId(final long aValue) {

		instance.setCommentId(aValue);

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
	public GeneratorT withBody(final String aValue) {

		instance.setBody(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withCreationDate(final LocalDate aValue) {

		instance.setCreationDate(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withLastEditDate(final LocalDate aValue) {

		instance.setLastEditDate(aValue);

		return (GeneratorT) this;
	}
}
