package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Metrics;

public interface  MetricsService {
	Metrics getMetricsByUserId(Long userId) throws SQLException;
	List<Metrics> getMetricsList() throws SQLException;
}
