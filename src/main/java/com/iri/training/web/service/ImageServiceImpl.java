package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Image;
import com.iri.training.repository.ImageRepository;

@Service
public  class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imgRepository;

	@Override
	public Image getImageById(Long imgId) throws SQLException {
		return imgRepository.getImageById(imgId);
	}

	@Override
	public Image getProfileImage(Long userId) throws SQLException {
		return 	imgRepository.getProfileImage(userId);
	}

	@Override
	public List<Image> getUserImages(Long userId) throws SQLException {
		return 	imgRepository.getUserImages(userId);
	}

	@Override
	public void addHobbies(final Image image) throws SQLException {
		imgRepository.addImage(image);

	}

	@Override
	public void removeHobbies(final Image image) throws SQLException {
		imgRepository.removeImage(image);
	}
}

