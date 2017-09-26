package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Image;
import com.iri.training.repository.ImageRepository;

@Service
public  class ImageServiceImpl implements ImageService {

	private static final Logger logger = Logger.getLogger(ImageRepository.class);

	@Autowired
	ImageRepository imgRepository;

	@Override
	public final Image getImageById(final long imgId) throws SQLException {

		logger.debug("ENTERED getImageById for imgId: " + imgId);

		final Image userImg = imgRepository.getImageById(imgId);

		logger.debug("EXITING getImageById with userImg: " + userImg);

		return userImg;
	}

	@Override
	public final Image getProfileImage(final long userId) throws SQLException {

		logger.debug("ENTERED getProfileImage for userId: " + userId);

		final Image userProfileImg = imgRepository.getProfileImage(userId);

		logger.debug("EXITING getProfileImage with userProfileImg: " + userProfileImg);

		return userProfileImg;
	}

	@Override
	public final List<Image> getUserImages(final long userId) throws SQLException {

		logger.debug("ENTERED getUserImages for userId: " + userId);

		final List<Image> images = imgRepository.getUserImages(userId);

		logger.debug("EXITING getUserImages for userId: " + userId);

		return images;
	}
}

