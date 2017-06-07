package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Hobby;
import com.iri.training.repository.HobbyRepository;

@Service
public class HobbyServiceImpl implements HobbyService{

	@Autowired
	HobbyRepository hobbyRepository;

	@Override
	public Hobby getHobbyById(Long hobbyId) throws SQLException {
		return hobbyRepository.getHobbyById(hobbyId);
	}

	@Override
	public ArrayDeque<Hobby> getHobbyList() throws SQLException {
		return hobbyRepository.getHobbyList();
	}

	@Override
	public ArrayList<Hobby> getUserHobbies(Long userId) throws SQLException {
		final ArrayList<Hobby> userHobbies = new ArrayList<>();

		for (Long hobbyId : hobbyRepository.getUserHobbies(userId))
		{
			userHobbies.add(getHobbyById(hobbyId));
		}

		return userHobbies;
	}
}
