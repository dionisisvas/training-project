package com.iri.training.model.builder;

import com.iri.training.model.UserImage;

public class UserImageBuilder extends UserImageBuilderBase<UserImageBuilder> {
	public static UserImageBuilder userImage() { return new UserImageBuilder(); }

	public UserImageBuilder() { super(new UserImage()); }

	public UserImage build() { return getInstance(); }
}

class UserImageBuilderBase<GeneratorT extends UserImageBuilderBase<GeneratorT>> {
	private final UserImage instance;

	protected UserImageBuilderBase(final UserImage aInstance) { instance = aInstance; }

	protected UserImage getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withImageId(final Long aValue) {
		instance.setImgId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withUserId(final Long aValue) {
		instance.setUserId(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withIsProfileImage(final boolean aValue) {
		instance.setProfileImg(aValue);

		return (GeneratorT) this;
	}

	@SuppressWarnings("unchecked")
	public GeneratorT withImageUri(final String aValue) {
		instance.setImgUri(aValue);

		return (GeneratorT) this;
	}
}