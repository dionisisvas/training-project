package com.iri.training.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iri.training.model.Metrics;
import com.iri.training.web.service.MetricsService;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/metrics")
public class MetricsController {

	Logger logger = Logger.getLogger(MetricsController.class);

	@Autowired
	MetricsService metricsService;

	@RequestMapping(value = "id/{userId}", method = RequestMethod.GET)
	public Metrics getMetricsByUserId(final HttpServletRequest request,@PathVariable final Long userId) throws SQLException {

		logger.debug("ENTERED getMetricsByUserId");

		Metrics metrics = metricsService.getMetricsByUserId(userId);

		logger.debug("EXITING getMetricsByUserId");

		return metrics;
	}
	}
