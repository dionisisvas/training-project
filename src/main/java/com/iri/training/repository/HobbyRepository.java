package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Hobby;

public interface HobbyRepository {

	Hobby getHobbyById(Long hobbyId) throws SQLException;

	List<Long> getUserHobbies(Long userId) throws SQLException;

	List<Hobby> getHobbyList() throws SQLException;
	void addHobbies(List<Hobby> hobby) throws SQLException;
	Hobby removeHobbies(Long userId) throws SQLException;
}
