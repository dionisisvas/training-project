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

import com.iri.training.model.Hobby;
import com.iri.training.web.service.HobbyService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/hobby")
public class HobbyController {

	private static final Logger logger = Logger.getLogger(HobbyController.class);

	@Autowired
	HobbyService hobbyService;

	@RequestMapping(value = "/{hobbyId}", method = RequestMethod.GET)
	public ResponseEntity<Hobby> getHobby(@PathVariable("hobbyId") Long hobbyId) throws SQLException {

		logger.debug("ENTERED getHobby for hobbyId: " + hobbyId);

		Hobby hobby = hobbyService.getHobbyById(hobbyId);

		logger.debug("EXITING getHobby for hobbyId: " + hobbyId);

		if (hobby != null) {
			return new ResponseEntity<Hobby>(hobby, HttpStatus.OK);
		}

		return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Hobby>> getAllHobbies() throws SQLException {

		logger.debug("ENTERED getAllHobbies");

		ArrayList<Hobby> hobbies = (ArrayList) hobbyService.getHobbyList();

		logger.debug("EXITING getAllHobbies");

		if (hobbies != null) {
			return new ResponseEntity<ArrayList<Hobby>>(hobbies, HttpStatus.OK);
		}

		return new ResponseEntity<ArrayList<Hobby>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Hobby>> getAllUserHobbies(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getAllUserHobbies for userId: " + userId);

		ArrayList<Hobby> hobbies = (ArrayList) hobbyService.getUserHobbies(userId);

		logger.debug("EXITING getAllUserHobbies for userId: " + userId);

		if (hobbies != null) {
			return new ResponseEntity<ArrayList<Hobby>>(hobbies, HttpStatus.OK);
		}

		return new ResponseEntity<ArrayList<Hobby>>(HttpStatus.NOT_FOUND);
	}
}
