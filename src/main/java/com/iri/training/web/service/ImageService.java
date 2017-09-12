package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Image;

public interface ImageService {

	Image getImageById(Long imgId) throws SQLException;

	Image getProfileImage(Long userId) throws SQLException;

	List<Image> getUserImages(Long userId) throws SQLException;
	void addHobbies(Image image) throws SQLException;
	void removeHobbies(Image image) throws SQLException;
}
