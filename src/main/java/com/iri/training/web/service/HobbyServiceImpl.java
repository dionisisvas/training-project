package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Hobby;
import com.iri.training.repository.HobbyRepository;

@Service
public class HobbyServiceImpl implements HobbyService{

	private static final Logger logger = Logger.getLogger(HobbyService.class);

	@Autowired
	HobbyRepository hobbyRepository;

	@Override
	public final Hobby getHobbyById(final long hobbyId) throws SQLException {

		logger.debug("ENTERED getHobbyById for hobbyId: " + hobbyId);

		final Hobby hobby =  hobbyRepository.getHobbyById(hobbyId);

		logger.debug("ENTERED getHobbyById with hobby: " + hobby);

		return hobby;
	}

	@Override
	public final List<Hobby> getUserHobbies(final long userId) throws SQLException {

		logger.debug("ENTERED getUserHobbies for userId: " + userId);

		final List<Hobby> userHobbies = new ArrayList<>();

		for (long hobbyId : hobbyRepository.getUserHobbies(userId)) {
			userHobbies.add(getHobbyById(hobbyId));
		}

		logger.debug("EXITING getUserHobbies for userId: " + userId +
			" with hobbies: " + userHobbies);

		return userHobbies;
	}

	@Override
	public List<Hobby> getHobbyList() throws SQLException {

		logger.debug("ENTERED getHobbyList");

		final List<Hobby> hobbyList = new ArrayList<>(hobbyRepository.getHobbyList());

		logger.debug("EXITING getHobbyList");

		return hobbyList;
	}
}
