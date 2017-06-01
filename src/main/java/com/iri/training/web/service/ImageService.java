package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iri.training.model.Image;

public interface ImageService {

	Image getImageById(Long imgId) throws SQLException;

	Image getProfileImage(Long userId) throws SQLException;

	ArrayList<Image> getUserImages(Long userId) throws SQLException;
}
