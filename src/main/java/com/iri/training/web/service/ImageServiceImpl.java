package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.UserImage;
import com.iri.training.repository.ImageRepository;

@Service
public  class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imgRepository;

	@Override
	public UserImage getImageById(Long imgId) throws SQLException {
		return imgRepository.getImageById(imgId);
	}

	@Override
	public UserImage getProfileImage(Long userId) throws SQLException {
		return 	imgRepository.getProfileImage(userId);
	}

	@Override
	public ArrayList<UserImage> getUserImages(Long userId) throws SQLException {
		return 	imgRepository.getUserImages(userId);
	}
}

