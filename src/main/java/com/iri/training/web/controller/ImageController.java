package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Image;
import com.iri.training.web.service.ImageService;

@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

	Logger logger = Logger.getLogger(ImageController.class);

	@Autowired
	ImageService imgService;

	@RequestMapping(value = "/{imgId}", method = RequestMethod.GET)
	public ResponseEntity<Image> getUserImage(@PathVariable("imgId") Long imgId) throws SQLException {

		logger.debug("ENTERED getUserImage");

		Image userImg = imgService.getImageById(imgId);
		if (userImg != null) {
			return new ResponseEntity<Image>(userImg, HttpStatus.OK);
		}

		logger.debug("EXITING getUserImage");

		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Image>> getAllUserImages(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getAllUserImages");

		ArrayList<Image> images = imgService.getUserImages(userId);
		if (images != null) {
			return new ResponseEntity<ArrayList<Image>>(images, HttpStatus.OK);
		}

		logger.debug("EXITING getAllUserImages");

		return new ResponseEntity<ArrayList<Image>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}/profile", method = RequestMethod.GET)
	public ResponseEntity<Image> getUserProfileImage(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getUserProfileImage");

		Image profileImage = imgService.getProfileImage(userId);
		if (profileImage != null) {
			return new ResponseEntity<Image>(profileImage, HttpStatus.OK);
		}

		logger.debug("EXITING getUserProfileImage");

		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
	}
}
