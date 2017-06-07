package com.iri.training.repository;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import com.iri.training.model.Hobby;

public interface HobbyRepository {

	Hobby getHobbyById(Long hobbyId) throws SQLException;

	ArrayList<Long> getUserHobbies(Long userId) throws SQLException;

	ArrayDeque<Hobby> getHobbyList() throws SQLException;
}
