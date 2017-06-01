package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.UserImage;
import com.iri.training.web.service.ImageService;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

	Logger logger = Logger.getLogger(ImageController.class);

	@Autowired
	ImageService imgService;

	@RequestMapping(value = "/{imgId}", method = RequestMethod.GET)
	public ResponseEntity<UserImage> getUserImage(@PathVariable("imgId") Long imgId) throws SQLException {

		logger.debug("ENTERED getUserImage");

		UserImage userImg = imgService.getImageById(imgId);
		if (userImg != null) {
			return new ResponseEntity<UserImage>(userImg, HttpStatus.OK);
		}

		logger.debug("EXITING getUserImage");

		return new ResponseEntity<UserImage>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<UserImage>> getAllUserImages(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getAllUserImages");

		ArrayList<UserImage> images = imgService.getUserImages(userId);
		if (images != null) {
			return new ResponseEntity<ArrayList<UserImage>>(images, HttpStatus.OK);
		}

		logger.debug("EXITING getAllUserImages");

		return new ResponseEntity<ArrayList<UserImage>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserImage> getUserProfileImage(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getUserProfileImage");

		UserImage profileImage = imgService.getProfileImage(userId);
		if (profileImage != null) {
			return new ResponseEntity<UserImage>(profileImage, HttpStatus.OK);
		}

		logger.debug("EXITING getUserProfileImage");

		return new ResponseEntity<UserImage>(HttpStatus.NOT_FOUND);
	}
}
