package com.iri.training.repository;

import java.sql.SQLException;

import com.iri.training.model.Statistics;

public interface  StatisticsRepository {

	Statistics getUsersAge() throws SQLException;
}
