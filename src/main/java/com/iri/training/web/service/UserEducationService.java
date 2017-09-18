package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.UserEducation;

public interface UserEducationService {

	List<UserEducation> getUserEducationByUserId(long userId) throws SQLException;

	EducationLevel getUserEducationLevel(long userId) throws SQLException;

	List<Long> getUsersByEducationLevel(EducationLevel educationLevel) throws SQLException;

	int getUserPopulationByEducationLevel(EducationLevel educationLevel) throws SQLException;
}
