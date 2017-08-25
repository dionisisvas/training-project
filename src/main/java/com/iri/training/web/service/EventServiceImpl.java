package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Events;
import com.iri.training.repository.EventRepository;
@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventRepository eventRepository;

	@Override public List<Events> getUserDates(final Long userId) throws SQLException {

		return eventRepository.getUserDates(userId);
	}
}