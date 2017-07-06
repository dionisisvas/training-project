package com.iri.training.model.builder;

import com.iri.training.model.UserComment;

public class UserCommentBuilder extends UserCommentBuilderBase<UserCommentBuilder> {
	public static UserCommentBuilder userComment(){return new UserCommentBuilder();}
	public  UserCommentBuilder() {super( new UserComment());}
	public UserComment build() {
		return getInstance();
	}
}

class UserCommentBuilderBase<GeneratorT extends UserCommentBuilderBase<GeneratorT>> {
	private final UserComment instance;

	protected UserCommentBuilderBase(final UserComment aInstance) {
		instance = aInstance;
	}

	protected UserComment getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDescription(final String aValue) {
		instance.setDescription(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDate(final String aValue) {
		instance.setDate(aValue);

		return (GeneratorT) this;
	}
	@SuppressWarnings("unchecked")
	public GeneratorT withCommID(final int aValue) {
		instance.setCommID(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUserID(final int aValue) {
		instance.setUserID(aValue);

		return (GeneratorT) this;
	}
}
