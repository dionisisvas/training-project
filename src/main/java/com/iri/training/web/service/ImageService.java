package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Image;

public interface ImageService {

	Image getImageById(long imgId) throws SQLException;

	Image getProfileImage(long userId) throws SQLException;

	List<Image> getUserImages(long userId) throws SQLException;

	void addImage(Image image) throws SQLException;

	void deleteImage(Image image) throws SQLException;
}
