package com.iri.training.web.service;

import java.sql.SQLException;

import com.iri.training.model.Statistics;

public interface StatisticsService {
	Statistics getUsersAge() throws SQLException;
}
