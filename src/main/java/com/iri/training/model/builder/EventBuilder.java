package com.iri.training.model.builder;

import java.time.LocalDate;

import com.iri.training.model.Events;


public class EventBuilder extends EventBuilderBase<EventBuilder> {
	public static EventBuilder event() { return new EventBuilder(); }

	public EventBuilder() { super(new Events()); }

	public Events build() { return getInstance(); }
}

class EventBuilderBase<GeneratorT extends EventBuilderBase<GeneratorT>> {
	private final Events instance;

	protected EventBuilderBase(final Events aInstance) { instance = aInstance; }

	protected Events getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withEventId(final Long aValue) {
		instance.setEventId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUserId(final Long aValue) {
		instance.setUserId(aValue);

		return (GeneratorT) this;
	}


	@SuppressWarnings("unchecked")
	public GeneratorT withDateOfEvent(final LocalDate aValue) {
		instance.setDateOfEvent(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withDescription(final String aValue) {
		instance.setDescription(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withTitle(final String aValue) {
		instance.setTitle(aValue);

		return (GeneratorT) this;
	}
}