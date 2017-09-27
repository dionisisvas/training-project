package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Events;
import com.iri.training.repository.EventRepository;
@Service
public final class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventRepository;

	@Override public List<Events> getUserDates(final Long userId) throws SQLException {

		return eventRepository.getUserDates(userId);
	}
	@Override
	public List<Events> getDatesList() throws SQLException {
		List<Events> datesList = new ArrayList<Events>(eventRepository.getDatesList());
		return datesList;
	}
	@Override
	public void addEvent(final Events events) throws SQLException {
		eventRepository.addEvent(events);

	}
}