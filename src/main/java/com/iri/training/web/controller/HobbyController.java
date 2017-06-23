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

@RestController
@RequestMapping(value = "/api/hobby")
public class HobbyController {

	Logger logger = Logger.getLogger(HobbyController.class);

	@Autowired
	HobbyService hobbyService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Hobby>> getAllHobbies() throws SQLException {

		logger.debug("ENTERED getAllHobbies");

		ArrayList<Hobby> hobbies = (ArrayList) hobbyService.getHobbyList();
		if (hobbies != null) {
			return new ResponseEntity<ArrayList<Hobby>>(hobbies, HttpStatus.OK);
		}

		logger.debug("EXITING getAllHobbies");

		return new ResponseEntity<ArrayList<Hobby>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{hobbyId}", method = RequestMethod.GET)
	public ResponseEntity<Hobby> getHobby(@PathVariable("hobbyId") Long hobbyId) throws SQLException {

		logger.debug("ENTERED getHobby for hobbyId: " + hobbyId);

		Hobby hobby = hobbyService.getHobbyById(hobbyId);
		if (hobby != null) {
			return new ResponseEntity<Hobby>(hobby, HttpStatus.OK);
		}

		logger.debug("EXITING getHobby for hobbyId: " + hobbyId);

		return new ResponseEntity<Hobby>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Hobby>> getAllUserHobbies(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getAllUserHobbies for userId: " + userId);

		ArrayList<Hobby> hobbies = (ArrayList) hobbyService.getUserHobbies(userId);
		if (hobbies != null) {
			return new ResponseEntity<ArrayList<Hobby>>(hobbies, HttpStatus.OK);
		}

		logger.debug("EXITING getAllUserHobbies for userId: " + userId);

		return new ResponseEntity<ArrayList<Hobby>>(HttpStatus.NOT_FOUND);
	}
}
