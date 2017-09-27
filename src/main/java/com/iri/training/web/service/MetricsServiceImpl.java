package com.iri.training.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Metrics;
import com.iri.training.repository.MetricsRepository;

@Service
public final class MetricsServiceImpl implements MetricsService{
	Logger logger = Logger.getLogger(MetricsServiceImpl.class);

	@Autowired
	MetricsRepository metricsRepository;

	@Override
	public Metrics getMetricsByUserId(final Long userId) throws SQLException {
		logger.debug("ENTERED getMetricsByUserId: " + userId);
		Metrics metrics = metricsRepository.getMetricsByUserId(userId);
		logger.debug("EXITING getMetricsByUserId " + metrics );
		return  metrics;
	}

	@Override
	public List<Metrics> getMetricsList() throws SQLException {
		List<Metrics> metricsList = new ArrayList<Metrics>(metricsRepository.getMetricsList());
		return metricsList;
	}

	@Override
	public void initializeUserMetrics(long userId) throws SQLException {
		metricsRepository.initializeUserMetrics(userId);
	}

	@Override public void updateMetrics(final Metrics metrics) throws SQLException {
		metricsRepository.updateMetrics(metrics);
	}
}
