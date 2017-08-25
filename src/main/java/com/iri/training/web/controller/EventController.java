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

import com.iri.training.model.Events;
import com.iri.training.web.service.EventService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api")
public class EventController {
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private  EventService eventService;

	@RequestMapping(value = "/dates/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Events>> getAllUserDates(@PathVariable("userId") Long userId) throws SQLException {

		logger.debug("ENTERED getAllUserDates for userId: " + userId);

		ArrayList<Events> events = (ArrayList) eventService.getUserDates(userId);

		logger.debug("EXITING getAllUserDates for userId: " + userId);

		if (events != null) {
			return new ResponseEntity<ArrayList<Events>>(events, HttpStatus.OK);
		}

		return new ResponseEntity<ArrayList<Events>>(HttpStatus.NOT_FOUND);
	}
}