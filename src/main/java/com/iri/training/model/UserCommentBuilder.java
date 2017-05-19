package com.iri.training.model;

import java.sql.Date;
import java.sql.Time;

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
	public GeneratorT withTime(final Time aValue) {
		instance.setTime(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDate(final Date aValue) {
		instance.setDate(aValue);

		return (GeneratorT) this;
	}


}
