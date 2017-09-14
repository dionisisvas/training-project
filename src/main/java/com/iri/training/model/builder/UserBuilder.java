package com.iri.training.model.builder;

import java.time.LocalDate;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.User;

public class UserBuilder extends UserBuilderBase<UserBuilder> {

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

class UserBuilderBase<GeneratorT extends UserBuilderBase<GeneratorT>> {

	private final User instance;

	protected UserBuilderBase(final User aInstance) { instance = aInstance; }

	protected User getInstance() {
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
	public GeneratorT withSurname(final String aValue) {

		instance.setSurname(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDateOfBirth(final LocalDate aValue) {

		instance.setDateOfBirth(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withPlaceOfBirth(final String aValue) {

		instance.setPlaceOfBirth(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withNationality(final String aValue) {

		instance.setNationality(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withEducation(final EducationLevel aValue) {

		instance.setEducation(aValue);

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

	@SuppressWarnings("unchecked")
	public GeneratorT withAge(final short aValue) {

		instance.setAge(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withHeight(final float aValue) {

		instance.setHeight(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withWeight(final float aValue) {

		instance.setWeight(aValue);

		return (GeneratorT) this;
	}
}