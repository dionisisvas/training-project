package com.iri.training.web.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iri.training.model.Metrics;
import com.iri.training.repository.MetricsRepository;

@Service
public class MetricsServiceImpl implements MetricsService{
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
}
