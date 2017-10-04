package com.iri.training.model.builder;

import com.iri.training.model.Image;

public class ImageBuilder extends ImageBuilderBase<ImageBuilder> {

	public static ImageBuilder userImage() {

		return new ImageBuilder();
	}

	public ImageBuilder() {

		super(new Image());
	}

	public Image build() {

		return getInstance();
	}
}

class ImageBuilderBase<GeneratorT extends ImageBuilderBase<GeneratorT>> {

	private final Image instance;

	protected ImageBuilderBase(final Image aInstance) {

		instance = aInstance;
	}

	protected Image getInstance() {

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
