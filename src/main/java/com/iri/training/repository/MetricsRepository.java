package com.iri.training.repository;

import java.sql.SQLException;
import java.util.List;

import com.iri.training.model.Metrics;

public interface MetricsRepository {

	Metrics getMetricsByUserId(Long userId) throws SQLException;

	List <Metrics> getMetricsList() throws SQLException;

	void initializeUserMetrics(long userId);
	void updateMetrics(Metrics metrics) throws SQLException;
}
