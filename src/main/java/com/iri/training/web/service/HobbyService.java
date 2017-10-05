package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Hobby;

public interface HobbyService {

	Hobby getHobbyById(long hobbyId) throws SQLException;

	List<Hobby> getUserHobbies(long userId) throws SQLException;

	List<Hobby> getHobbyList() throws SQLException;

	void addHobbies(List<Hobby> hobbies, long userId) throws SQLException;

	void deleteHobbies(long userId) throws SQLException;

	void editHobbies(List<Hobby> hobbies, long userId) throws SQLException;
}
