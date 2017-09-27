package com.iri.training.model.builder;

import com.iri.training.model.Hobby;

public class HobbyBuilder extends HobbyBuilderBase<HobbyBuilder> {

	public static HobbyBuilder userHobby() {

		return new HobbyBuilder();
	}

	public HobbyBuilder() {

		super(new Hobby());
	}

	public Hobby build() {

		return getInstance();
	}
}

class HobbyBuilderBase<GeneratorT extends HobbyBuilderBase<GeneratorT>> {

	private final Hobby instance;

	protected HobbyBuilderBase(final Hobby aInstance) {

		instance = aInstance;
	}

	protected Hobby getInstance() {

		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withId(final Long aValue) {

		instance.setId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withName(final String aValue) {

		instance.setName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDescription(final String aValue) {

		instance.setDescription(aValue);

		return (GeneratorT) this;
	}
}
