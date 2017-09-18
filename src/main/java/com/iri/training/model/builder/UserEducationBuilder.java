package com.iri.training.model.builder;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.UserEducation;

public class UserEducationBuilder extends UserEducationBuilderBase<UserEducationBuilder> {

	public static UserEducationBuilder user() {

		return new UserEducationBuilder();
	}

	public UserEducationBuilder() {

		super(new UserEducation());
	}

	public UserEducation build() {

		return getInstance();
	}
}

class UserEducationBuilderBase<GeneratorT extends UserEducationBuilderBase<GeneratorT>> {

	private final UserEducation instance;

	protected UserEducationBuilderBase(final UserEducation aInstance) { instance = aInstance; }

	protected UserEducation getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUserId(final Long aValue) {

		instance.setUserId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSchoolName(final String aValue) {

		instance.setSchoolName(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withEducationLevel(final EducationLevel aValue) {

		instance.setEducationLevel(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withGraduated(final boolean aValue) {

		instance.setGraduated(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDroppedOut(final boolean aValue) {

		instance.setDroppedOut(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withStartYear(final int aValue) {

		instance.setStartYear(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withEndYear(final int aValue) {

		instance.setEndYear(aValue);

		return (GeneratorT) this;
	}
}