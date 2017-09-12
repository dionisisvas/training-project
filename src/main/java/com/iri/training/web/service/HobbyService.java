package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Hobby;

public interface HobbyService {

	Hobby getHobbyById(Long hobbyId) throws SQLException;

	List<Hobby> getHobbyList() throws SQLException;

	List<Hobby> getUserHobbies(Long userId) throws SQLException;
	void addHobbies(List<Hobby> hobby) throws SQLException;
	Hobby removeHobbies(Long userId) throws SQLException;
	void editHobby(List<Hobby> hobbyList) throws SQLException;
}
