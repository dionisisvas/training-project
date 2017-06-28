package com.iri.training.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.model.Metrics;
import com.iri.training.model.builder.MetricsBuilder;

@Repository
public class MetricsRepositoryImpl implements MetricsRepository {
private	Logger logger = Logger.getLogger(MetricsRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();
	private FileInputStream fis = new FileInputStream("src/main/resources/sql_queries.properties");
	private PropertyResourceBundle property = new java.util.PropertyResourceBundle(fis);

	public MetricsRepositoryImpl() throws IOException {}


	@Override
	public Metrics getMetricsByUserId(final Long userId) throws SQLException {

		logger.debug("ENTERED getMetricsByUserId: " + userId);

		String sql=property.getString("SELECT_METRICS");
		jdbcTemplate=new JdbcTemplate(dataSource);
		Metrics metrics=jdbcTemplate.query(sql,new Object[]{userId},new UserMetricsMapper());
		logger.debug("EXITING getMetricsByUserId: " + metrics);
		return metrics;

	}

	@Override public List<Metrics> getMetricsList() throws SQLException {

		logger.debug("ENTERED getMetricsList");

		String sql = property.getString("");
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Metrics> metricsList = jdbcTemplate.query(sql, new MetricsRepositoryImpl.MetricsListResultSetExtractor());

		logger.debug("EXITING getMetricsList");

		return metricsList;
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
					.withPlace_of_birth(resultSet.getString("place_of_birth"))
					.withEducation(resultSet.getString("education"))
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
					.withPlace_of_birth(resultSet.getString("place_of_birth"))
					.withEducation(resultSet.getString("education"))
					.build());
			}

			return metricsList;
		}
	}

}