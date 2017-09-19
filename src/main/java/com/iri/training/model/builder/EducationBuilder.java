package com.iri.training.model.builder;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.Education;

public class EducationBuilder extends EducationBuilderBase<EducationBuilder> {

	public static EducationBuilder user() {

		return new EducationBuilder();
	}

	public EducationBuilder() {

		super(new Education());
	}

	public Education build() {

		return getInstance();
	}
}

class EducationBuilderBase<GeneratorT extends EducationBuilderBase<GeneratorT>> {

	private final Education instance;

	protected EducationBuilderBase(final Education aInstance) { instance = aInstance; }

	protected Education getInstance() {
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