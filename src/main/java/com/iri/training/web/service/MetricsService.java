package com.iri.training.web.service;

import java.sql.SQLException;

import com.iri.training.model.Metrics;

public interface  MetricsService {
	Metrics getMetricsByUserId(Long userId) throws SQLException;
}
