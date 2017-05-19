package com.iri.training.model;

public class UserBuilder extends UserBuilderBase<UserBuilder> {
	public static UserBuilder user() { return new UserBuilder(); }

	public UserBuilder() { super(new User()); }

	public User build() { return getInstance(); }
}

class UserBuilderBase<GeneratorT extends UserBuilderBase<GeneratorT>> {
	private final User instance;

	protected UserBuilderBase(final User aInstance) { instance = aInstance; }

	protected User getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUsername(final String aValue) {
		instance.setUsername(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUserId(final Long aValue) {
		instance.setUserId(aValue);

		return (GeneratorT) this;
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
	public GeneratorT withAge(final short aValue) {
		instance.setAge(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withPhoneNo(final String aValue) {
		instance.setPhoneNo(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withAddress(final String aValue) {
		instance.setAddress(aValue);

		return (GeneratorT) this;
	}
}