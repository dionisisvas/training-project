package com.iri.training.repository;

import java.sql.SQLException;

import java.util.List;

import com.iri.training.model.Image;

public interface ImageRepository {

	void addImage(Image image) throws SQLException;
	void removeImage(Image image) throws SQLException;
	Image getImageById(Long imgId) throws SQLException;

	Image getProfileImage(Long userId) throws SQLException;

	List<Image> getUserImages(Long userId) throws SQLException;
}
