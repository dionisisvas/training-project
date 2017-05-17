package com.iri.training.model;

public class ScenarioBuilder extends ScenarioBuilderBase<ScenarioBuilder> {
	public static ScenarioBuilder scenario() {
		return new ScenarioBuilder();
	}

	public ScenarioBuilder() {
		super(new Scenario());
	}

	public Scenario build() {
		return getInstance();
	}
}

class ScenarioBuilderBase<GeneratorT extends ScenarioBuilderBase<GeneratorT>> {
	private final Scenario instance;

	protected ScenarioBuilderBase(final Scenario aInstance) {
		instance = aInstance;
	}

	protected Scenario getInstance() {
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