package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Hobby;

public interface HobbyRepository {

	Hobby getHobbyById(long hobbyId) throws SQLException;

	List<Long> getUserHobbies(long userId) throws SQLException;

	List<Hobby> getHobbyList() throws SQLException;

	void addHobbies(List<Hobby> hobby) throws SQLException;

	void deleteHobbies(long userId) throws SQLException;
}
