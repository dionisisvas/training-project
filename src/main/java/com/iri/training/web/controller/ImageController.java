package com.iri.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Image;
import com.iri.training.web.service.ImageService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

	private static final Logger logger = Logger.getLogger(ImageController.class);

	@Autowired
	ImageService imgService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = "application/json")
	public ResponseEntity<String> addImage(@RequestBody Image image) throws SQLException {

		logger.debug("ENTERED addImage: ");

		if (image != null) {

			imgService.addImage(image);

			return new ResponseEntity("{\"message\": \"Add success.\"}", HttpStatus.OK);
		} else {

			return new ResponseEntity("{\"message\": \"Add failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = "application/json")
	public ResponseEntity<String> removeImage(@RequestBody Image image) throws SQLException {

		logger.debug("ENTERED addImage: ");

		if (image != null) {

			imgService.deleteImage(image);

			return new ResponseEntity("{\"message\": \"Remove success.\"}", HttpStatus.OK);
		} else {

			return new ResponseEntity("{\"message\": \"Remove failed.\"}", HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/{imgId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Image> getImageById(@PathVariable("imgId") final long imgId) throws SQLException {

		logger.debug("ENTERED getImageById for imgId: " + imgId);

		final Image userImg = imgService.getImageById(imgId);

		logger.debug("EXITING getImageById with userImg: " + userImg);

		if (userImg != null) {
			return new ResponseEntity<Image>(userImg, HttpStatus.OK);
		}

		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<Image>> getUserImages(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getUserImages for userId: " + userId);

		final List<Image> images = new ArrayList<>(imgService.getUserImages(userId));

		logger.debug("EXITING getUserImages for userId: " + userId);

		if (images != null) {
			return new ResponseEntity<List<Image>>(images, HttpStatus.OK);
		}

		return new ResponseEntity<List<Image>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}/profile", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Image> getUserProfileImage(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getUserProfileImage for userId: " + userId);

		final Image profileImg = imgService.getProfileImage(userId);

		logger.debug("EXITING getUserProfileImage for userId: " + userId);

		if (profileImg != null) {
			return new ResponseEntity<Image>(profileImg, HttpStatus.OK);
		}

		return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
	}
}
