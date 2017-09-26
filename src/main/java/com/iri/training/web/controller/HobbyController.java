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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Hobby;
import com.iri.training.web.service.HobbyService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/hobby")
public class HobbyController {

	private static final Logger logger = Logger.getLogger(HobbyController.class);

	@Autowired
	HobbyService hobbyService;

	@RequestMapping(value = "/{hobbyId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Hobby> getHobbyById(@PathVariable("hobbyId") final long hobbyId) throws SQLException {

		logger.debug("ENTERED getHobbyById for hobbyId: " + hobbyId);

		final Hobby hobby = hobbyService.getHobbyById(hobbyId);

		logger.debug("EXITING getHobbyById with hobby: " + hobby);

		if (hobby != null) {
			return new ResponseEntity<Hobby>(hobby, HttpStatus.OK);
		}

		return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<Hobby>> getUserHobbies(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getUserHobbies for userId: " + userId);

		final List<Hobby> hobbies = new ArrayList<>(hobbyService.getUserHobbies(userId));

		logger.debug("EXITING getUserHobbies for userId: " + userId +
			" with hobbies: " + hobbies);

		if (hobbies != null) {
			return new ResponseEntity<List<Hobby>>(hobbies, HttpStatus.OK);
		}

		return new ResponseEntity<List<Hobby>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public final ResponseEntity<List<Hobby>> getHobbyList() throws SQLException {

		logger.debug("ENTERED getHobbyList");

		final List<Hobby> hobbies = new ArrayList<>(hobbyService.getHobbyList());

		logger.debug("EXITING getHobbyList");

		if (hobbies != null) {
			return new ResponseEntity<List<Hobby>>(hobbies, HttpStatus.OK);
		}

		return new ResponseEntity<List<Hobby>>(HttpStatus.NOT_FOUND);
	}
}
