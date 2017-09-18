package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.enums.EducationLevel;
import com.iri.training.model.Education;

public interface EducationRepository {

	List<Education> getEducationByUserId(long userId) throws SQLException;

	List<Long> getUsersByEducationLevel(EducationLevel educationLevel) throws SQLException;
}
