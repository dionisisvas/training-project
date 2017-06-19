package com.iri.training.model.builder;

import com.iri.training.model.Statistics;

public class StatisticsBuilder extends StatisticsBuilderBase<StatisticsBuilder> {
	public static StatisticsBuilder statistics() { return new StatisticsBuilder(); }

	public StatisticsBuilder() { super(new Statistics()); }

	public Statistics build() { return getInstance(); }
}

class StatisticsBuilderBase<GeneratorT extends StatisticsBuilderBase<GeneratorT>> {
	private final Statistics instance;

	protected StatisticsBuilderBase(final Statistics aInstance) { instance = aInstance; }

	protected Statistics getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withFirst(final int aValue) {
		instance.setFirst_group(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSecond(final int aValue) {
		instance.setSecond_group(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withThird(final int aValue) {
		instance.setThird_group(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withForth(final int aValue) {
		instance.setFourth_group(aValue);

		return (GeneratorT) this;
	}


	@SuppressWarnings("unchecked")
	public GeneratorT withFifth(final int aValue) {
		instance.setFifth_group(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSixth(final int aValue) {
		instance.setSixth_group(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withSeventh(final int aValue) {
		instance.setSeventh_group(aValue);

		return (GeneratorT) this;
	}
}