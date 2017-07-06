package com.iri.training.model.builder;

import com.iri.training.model.Metrics;

public class MetricsBuilder extends MetricsBuilderBase<MetricsBuilder> {
	public static UserBuilder user() { return new UserBuilder(); }

	public MetricsBuilder() { super(new Metrics()); }

	public Metrics build() { return getInstance(); }
}

	class MetricsBuilderBase<GeneratorT extends com.iri.training.model.builder.MetricsBuilderBase<GeneratorT>> {
		private final Metrics instance;

		protected MetricsBuilderBase(final Metrics aInstance) { instance = aInstance; }

		protected Metrics getInstance() {
			return instance;
		}

		@SuppressWarnings("unchecked")
		public GeneratorT withHeight(final double aValue) {
			instance.setHeight(aValue);

			return (GeneratorT) this;
		}

		@SuppressWarnings("unchecked")
		public GeneratorT withWeight(final double aValue) {
			instance.setWeight(aValue);

			return (GeneratorT) this;
		}

		@SuppressWarnings("unchecked")
		public GeneratorT withNationality(final String aValue) {
			instance.setNationality(aValue);

			return (GeneratorT) this;
		}

		@SuppressWarnings("unchecked")
		public GeneratorT withPlace_of_birth(final String aValue) {
			instance.setPlace_of_birth(aValue);

			return (GeneratorT) this;
		}
		@SuppressWarnings("unchecked")
		public GeneratorT withEducation(final String aValue) {
			instance.setEducation(aValue);

			return (GeneratorT) this;
		}

	}

