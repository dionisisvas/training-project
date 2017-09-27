package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.Metrics;
import com.iri.training.model.builder.MetricsBuilder;

@Repository
public final class MetricsRepositoryImpl implements MetricsRepository {

	private static final Logger logger = Logger.getLogger(MetricsRepository.class);

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();

	@Override
	public Metrics getMetricsByUserId(final Long userId) throws SQLException {

		logger.debug("ENTERED getMetricsByUserId: " + userId);

		jdbcTemplate = new JdbcTemplate(dataSource);
		Metrics metrics = jdbcTemplate.query(PropertiesConfig.GET_METRICS_BY_USER_ID,
			new Object[]{userId},
			new UserMetricsMapper());

		logger.debug("EXITING getMetricsByUserId: " + metrics);

		return metrics;

	}

	@Override public List<Metrics> getMetricsList() throws SQLException {

		logger.debug("ENTERED getMetricsList");

		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Metrics> metricsList = jdbcTemplate.query(PropertiesConfig.GET_METRICS_LIST,
			new MetricsRepositoryImpl.MetricsListResultSetExtractor());

		logger.debug("EXITING getMetricsList");

		return metricsList;
	}

	@Override
	public void initializeUserMetrics(final long userId) {

		logger.debug("ENTERED initializeUserMetrics");
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(PropertiesConfig.INIT_USER_METRICS,
			new Object[]{userId});

		logger.debug("EXITING initializeUserMetrics");
	}

	@Override
	public void updateMetrics(final Metrics metrics) throws SQLException {

		logger.debug("ENTERED updateMetrics : " + metrics);

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(PropertiesConfig.EDIT_METRICS,
			metrics.getWeight(),
			metrics.getHeight(),
			metrics.getEducation(),
			metrics.getNationality(),
			metrics.getPlaceOfBirth(),
			metrics.getUserId());

		logger.debug("EXITING updateMetrics: " + metrics);
	}

	private static final class UserMetricsMapper implements ResultSetExtractor<Metrics> {

		@Override
		public Metrics extractData(final ResultSet resultSet) throws SQLException {
			final Metrics metrics;

			if (resultSet.next()) {
				metrics = new MetricsBuilder()
					.withHeight(resultSet.getDouble("height"))
					.withWeight(resultSet.getDouble("weight"))
					.withNationality(resultSet.getString("nationality"))
					.withPlaceOfBirth(resultSet.getString("placeOfBirth"))
					.withEducation(resultSet.getString("education"))
					.withUserId(resultSet.getLong("userId"))
					.build();
			}
			else
			{
				return null;
			}

			return  metrics;
		}
	}

	private static final class MetricsListResultSetExtractor implements ResultSetExtractor<List<Metrics>> {

		@Override
		public List<Metrics> extractData(final ResultSet resultSet) throws SQLException {

			final List<Metrics> metricsList = new ArrayList<>();
			while (resultSet.next()) {
				metricsList.add(new MetricsBuilder()
					.withHeight(resultSet.getDouble("height"))
					.withWeight(resultSet.getDouble("weight"))
					.withNationality(resultSet.getString("nationality"))
					.withPlaceOfBirth(resultSet.getString("placeOfBirth"))
					.withEducation(resultSet.getString("education"))
					.withUserId(resultSet.getLong("userId"))
					.build());
			}

			return metricsList;
		}
	}

}