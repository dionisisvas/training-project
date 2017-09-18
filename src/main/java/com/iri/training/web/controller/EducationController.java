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

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.Education;
import com.iri.training.web.service.EducationService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/api/education")
public final class EducationController {

	private static final Logger logger = Logger.getLogger(EducationController.class);

	@Autowired
	EducationService educationService;

	@RequestMapping(value = "/uid/{userId}", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<Education>> getEducationByUserId(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getEducationByUserId for userId: " + userId);

		final List<Education> userEducation = new ArrayList<>(educationService.getEducationByUserId(userId));

		logger.debug("EXITING getEducationByUserId for userEducation: " + userEducation);

		if (!userEducation.isEmpty()) {
			return new ResponseEntity<>(userEducation, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/level/uid/{userId}", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<EducationLevel> getEducationLevelByUserId(@PathVariable("userId") final long userId) throws SQLException {

		logger.debug("ENTERED getEducationLevelByUserId for userId: " + userId);

		final EducationLevel educationLevel = educationService.getEducationLevelByUserId(userId);

		logger.debug("EXITING getEducationLevelByUserId for userId: " + userId + " with education level: "
			+ educationLevel);

		if (educationLevel != null) {
			return new ResponseEntity<>(educationLevel, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/level/{educationLevel}/users", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<List<Long>> getUsersByEducationLevel(@PathVariable("educationLevel") final EducationLevel educationLevel) throws SQLException {

		logger.debug("ENTERED getUsersByEducationLevel for educationLevel: " + educationLevel);

		final List<Long> userIdList = new ArrayList<>(educationService.getUsersByEducationLevel(educationLevel));

		logger.debug("EXITING getUsersByEducationLevel for educationLevel: " + educationLevel);

		if (!userIdList.isEmpty()) {
			return new ResponseEntity<>(userIdList, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/level/{educationLevel}/population", method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Integer> getUserPopulationByEducationLevel(@PathVariable("educationLevel") final EducationLevel educationLevel) throws SQLException {

		logger.debug("ENTERED getUserPopulationByEducationLevel for educationLevel: " + educationLevel);

		final int population = educationService.getUserPopulationByEducationLevel(educationLevel);

		logger.debug("EXITING getUserPopulationByEducationLevel for educationLevel: " + educationLevel + ", with population: "
			+ population);

		return new ResponseEntity<>(population, HttpStatus.OK);
	}
}
