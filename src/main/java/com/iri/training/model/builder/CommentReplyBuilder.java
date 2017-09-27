package com.iri.training.model.builder;

import java.time.LocalDateTime;

import com.iri.training.model.CommentReply;

public class CommentReplyBuilder extends CommentReplyBuilderBase<CommentReplyBuilder> {

	public static CommentReplyBuilder comment() {

		return new CommentReplyBuilder();
	}

	public CommentReplyBuilder() {

		super(new CommentReply());
	}

	public CommentReply build() {

		return getInstance();
	}
}

class CommentReplyBuilderBase<GeneratorT extends CommentReplyBuilderBase<GeneratorT>> {

	private final CommentReply instance;

	protected CommentReplyBuilderBase(final CommentReply aInstance) {

		instance = aInstance;
	}

	protected CommentReply getInstance() {

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
	public GeneratorT withParentId(final long aValue) {

		instance.setParentId(aValue);

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
}
