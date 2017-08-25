package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Events;

public interface EventRepository {

	List<Events> getUserDates(Long userId) throws SQLException;
}
