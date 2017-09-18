package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.Education;
import com.iri.training.repository.EducationRepository;

@Service
public final class EducationServiceImpl implements EducationService {

	private static final Logger logger = Logger.getLogger(EducationServiceImpl.class);

	@Autowired
	EducationRepository educationRepository;

	@Override
	public final List<Education> getEducationByUserId(final long userId) throws SQLException {

		logger.debug("ENTERED getEducationByUserId for userId: " + userId);

		final List<Education> userEducation = new ArrayList<>(educationRepository.getEducationByUserId(userId));

		logger.debug("EXITING getEducationByUserId for userEducation: " + userEducation);

		return userEducation;
	}

	@Override
	public final EducationLevel getEducationLevelByUserId(long userId) throws SQLException {

		logger.debug("ENTERED getEducationLevelByUserId for userId: " + userId);

		final List<Education> userEducation = new ArrayList<>(this.getEducationByUserId(userId));

		EducationLevel highestEducationLevel = EducationLevel.NO_SCHOOL;

		// Iterate over the user's education items and find the highest attained education level
		for (Education educationItem : userEducation ) {
			final EducationLevel educationItemLevel;

			// There was no school data found in the DB.
			if (educationItem.getEducationLevel() == EducationLevel.NO_SCHOOL) {
				break;
			}

			// If graduated, the level is attained. If not decrement by one.
			if (educationItem.isGraduated()) {
				educationItemLevel = educationItem.getEducationLevel();
			}
			else {
				educationItemLevel = EducationLevel.values()[educationItem.getEducationLevel().ordinal() - 1];
			}

			if (highestEducationLevel == EducationLevel.NO_SCHOOL) {
				highestEducationLevel = educationItemLevel;
			}
			else {
				if (educationItemLevel.ordinal() > highestEducationLevel.ordinal()) {
					highestEducationLevel = educationItemLevel;
				}
			}
		}

		logger.debug("EXITING getEducationLevelByUserId for userId: " + userId + " with education level: "
			+ highestEducationLevel);

		return highestEducationLevel;
	}

	@Override
	public final List<Long> getUsersByEducationLevel(final EducationLevel educationLevel) throws SQLException {

		logger.debug("ENTERED getUsersByEducationLevel for educationLevel: " + educationLevel);

		final List<Long> userIdList = new ArrayList<>(educationRepository.getUsersByEducationLevel(educationLevel));

		logger.debug("EXITING getUsersByEducationLevel for educationLevel: " + educationLevel);

		return userIdList;
	}

	@Override
	public final int getUserPopulationByEducationLevel(final EducationLevel educationLevel) throws SQLException {
		logger.debug("ENTERED getUserPopulationByEducationLevel for educationLevel: " + educationLevel);

		final int population;
		final List<Long> userIdList = new ArrayList<>(educationRepository.getUsersByEducationLevel(educationLevel));

		population = userIdList.size();

		logger.debug("EXITING getUserPopulationByEducationLevel for educationLevel: " + educationLevel + ", with population: "
			+ population);

		return population;
	}
}
