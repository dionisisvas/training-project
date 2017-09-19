package com.iri.training.model.builder;

import java.time.LocalDateTime;

import com.iri.training.model.Account;

public class AccountBuilder extends AccountBuilderBase<AccountBuilder> {

	public static AccountBuilder account() {

		return new AccountBuilder();
	}

	public AccountBuilder() {

		super(new Account());
	}

	public Account build() {

		return getInstance();
	}
}

class AccountBuilderBase<GeneratorT extends AccountBuilderBase<GeneratorT>> {

	private final Account instance;

	protected AccountBuilderBase(final Account aInstance) {

		instance = aInstance;
	}

	protected Account getInstance() {

		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withId(final long aValue) {

		instance.setId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUsername(final String aValue) {

		instance.setUsername(aValue);

		return (GeneratorT) this;
	}

	public GeneratorT withPassword(final String aValue) {

		instance.setPassword(aValue);

		return (GeneratorT) this;
	}

	public GeneratorT withEmail(final String aValue) {

		instance.setEmail(aValue);

		return (GeneratorT) this;
	}

	public GeneratorT withJoinDate(final LocalDateTime aValue) {

		instance.setJoinDate(aValue);

		return (GeneratorT) this;
	}
}
