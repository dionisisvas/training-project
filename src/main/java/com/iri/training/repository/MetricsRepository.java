package com.iri.training.repository;

import java.sql.SQLException;

import com.iri.training.model.Metrics;

public interface MetricsRepository {

	 Metrics getMetricsByUserId(Long userId) throws SQLException;


}
