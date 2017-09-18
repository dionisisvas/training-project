package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.UserEducation;
import com.iri.training.repository.UserEducationRepository;

public final class UserEducationServiceImpl implements  UserEducationService {

	private static final Logger logger = Logger.getLogger(UserEducationServiceImpl.class);

	@Autowired
	UserEducationRepository userEducationRepository;

	@Override
	public final UserEducation getUserEducationByUserId(final long userId) throws SQLException {

		logger.debug("ENTERED getUserEducationByUserId for userId: " + userId);

		final UserEducation userEducation = userEducationRepository.getUserEducationByUserId(userId);

		logger.debug("EXITING getUserEducationByUserId for userEducation" + userEducation);

		return userEducation;
	}

	@Override
	public final List<Long> getUsersByEducationLevel(final EducationLevel educationLevel) throws SQLException {

		logger.debug("ENTERED getUsersByEducationLevel for educationLevel: " + educationLevel);

		final List<Long> userIdList = new ArrayList<>(userEducationRepository.getUsersByEducationLevel(educationLevel));

		logger.debug("EXITING getUsersByEducationLevel for educationLevel: " + educationLevel);

		return userIdList;
	}

	@Override
	public final int getUserPopulationByEducationLevel(final EducationLevel educationLevel) throws SQLException {
		logger.debug("ENTERED getUserPopulationByEducationLevel for educationLevel: " + educationLevel);

		final int population;
		final List<Long> userIdList = new ArrayList<>(userEducationRepository.getUsersByEducationLevel(educationLevel));

		population = userIdList.size();

		logger.debug("EXITING getUserPopulationByEducationLevel for educationLevel: " + educationLevel + ", with population: "
			+ population);

		return population;
	}
}
