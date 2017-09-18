package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.UserEducation;
import com.iri.training.repository.UserEducationRepository;

@Service
public final class UserEducationServiceImpl implements  UserEducationService {

	private static final Logger logger = Logger.getLogger(UserEducationServiceImpl.class);

	@Autowired
	UserEducationRepository userEducationRepository;

	@Override
	public final List<UserEducation> getUserEducationByUserId(final long userId) throws SQLException {

		logger.debug("ENTERED getUserEducationByUserId for userId: " + userId);

		final List<UserEducation> userEducation = new ArrayList<>(userEducationRepository.getUserEducationByUserId(userId));

		logger.debug("EXITING getUserEducationByUserId for userEducation: " + userEducation);

		return userEducation;
	}

	@Override
	public final EducationLevel getUserEducationLevel(long userId) throws SQLException {

		logger.debug("ENTERED getUserEducationLevel for userId: " + userId);

		final List<UserEducation> userEducation = new ArrayList<>(this.getUserEducationByUserId(userId));

		EducationLevel highestEducationLevel = EducationLevel.NO_SCHOOL;

		// Iterate over the user's education items and find the highest attained education level
		for (UserEducation educationItem : userEducation ) {
			final EducationLevel educationLevel;

			// There was no school data found in the DB.
			if (educationItem.getEducationLevel() == EducationLevel.NO_SCHOOL) {
				break;
			}

			// If graduated, the level is attained. If not decrement by one.
			if (educationItem.isGraduated()) {
				educationLevel = educationItem.getEducationLevel();
			}
			else {
				educationLevel = EducationLevel.values()[educationItem.getEducationLevel().ordinal() - 1];
			}

			if (highestEducationLevel == EducationLevel.NO_SCHOOL) {
				highestEducationLevel = educationLevel;
			}
			else {
				if (educationLevel.ordinal() > highestEducationLevel.ordinal()) {
					highestEducationLevel = educationLevel;
				}
			}
		}

		logger.debug("EXITING getUserEducationLevel for userId: " + userId + " with education level: " + highestEducationLevel);

		return highestEducationLevel;
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
