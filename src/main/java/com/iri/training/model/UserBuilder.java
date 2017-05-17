package com.iri.training.model;

public class UserBuilder extends BuildBase<UserBuilder> {
	public static UserBuilder user() {
		return new UserBuilder();
	}

	public UserBuilder() {
		super(new User());
	}

	public User build() {
		return getInstance();
	}
}

class BuildBase<GeneratorT extends BuildBase<GeneratorT>> {
	private final User instance;

	protected BuildBase(final User aInstance) {
		instance = aInstance;
	}

	protected User getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withName(final String aValue) {
		instance.setName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSurname(final String aValue) {
		instance.setSurname(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUsername(final String aValue) {
		instance.setUsername(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withPassword(final String aValue) {
		instance.setPassword(aValue);

		return (GeneratorT) this;
	}

}