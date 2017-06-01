package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.iri.training.model.UserImage;

public interface ImageService {

	UserImage getImageById(Long imgId) throws SQLException;

	UserImage getProfileImage(Long userId) throws SQLException;

	ArrayList<UserImage> getUserImages(Long userId) throws SQLException;
}
