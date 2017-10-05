package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Events;

public interface EventRepository {

	void addEvent(Events events) throws SQLException;
	List<Events> getUserDates(Long userId) throws SQLException;
	List<Events> getDatesList() throws SQLException;
}