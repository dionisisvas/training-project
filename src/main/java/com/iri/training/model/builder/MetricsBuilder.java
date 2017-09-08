package com.iri.training.model.builder;

import com.iri.training.model.Metrics;

public class MetricsBuilder extends MetricsBuilderBase<MetricsBuilder> {
	public static MetricsBuilder metrics() { return new MetricsBuilder(); }

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
		public GeneratorT withPlaceOfBirth(final String aValue) {
			instance.setPlaceOfBirth(aValue);

			return (GeneratorT) this;
		}
		@SuppressWarnings("unchecked")
		public GeneratorT withEducation(final String aValue) {
			instance.setEducation(aValue);

			return (GeneratorT) this;
		}
		public GeneratorT withUserId(final Long aValue) {
			instance.setUserId(aValue);

			return (GeneratorT) this;
		}

	}

