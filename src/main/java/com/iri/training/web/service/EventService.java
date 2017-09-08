package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Events;

public interface EventService {
	List<Events> getUserDates(Long userId) throws SQLException;

	List<Events> getDatesList() throws SQLException;
}