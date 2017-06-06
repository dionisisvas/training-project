package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;

import com.iri.training.model.Hobby;

public interface HobbyService {

	Hobby getHobbyById(Long hobbyId) throws SQLException;

	ArrayDeque<Hobby> getHobbyList() throws SQLException;

	ArrayList<Hobby> getUserHobbies(Long userId) throws SQLException;
}
