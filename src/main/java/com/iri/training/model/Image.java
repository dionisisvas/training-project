package com.iri.training.model;

public class Image {

	private Long imgId;
	private Long userId;
	private boolean isProfileImg;
	private String imgUri;

	public Long getImgId() { return imgId;	}

	public void setImgId(final Long imgId) { this.imgId = imgId; }

	public Long getUserId() { return userId; }

	public void setUserId(final Long userId) { this.userId = userId; }

	public boolean isProfileImg() { return isProfileImg; }

	public void setProfileImg(final boolean profileImg) { isProfileImg = profileImg; }

	public String getImgUri() { return imgUri; }

	public void setImgUri(final String imgUri) { this.imgUri = imgUri; }
}
