package com.iri.training.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.iri.training.config.PropertiesConfig;
import com.iri.training.model.Events;
import com.iri.training.model.builder.EventBuilder;
@Repository
public class EventRepositoryImpl implements EventRepository {

	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();

	@Override
	public List<Events> getUserDates(Long userId) throws SQLException {

		logger.debug("ENTERED getUserDates for userId: " + userId);

		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Events> userDates = jdbcTemplate.query(PropertiesConfig.GET_EVENTS_BY_USER_ID,
			new Object[]{userId},
			new UserDateListResultSetExtractor());

		logger.debug("EXITING getUserDates");

		return userDates;
	}
	@Override
	public List<Events> getDatesList() throws SQLException {
		logger.debug("ENTERED getDatesList");

		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Events> dates = jdbcTemplate.query(PropertiesConfig.GET_EVENT_LIST,
			new UserDateListResultSetExtractor());

		logger.debug("EXITING getDatesList: " + dates);

		return dates;
	}

	private static final class UserDateListResultSetExtractor implements ResultSetExtractor<List<Events>> {

		@Override
		public List<Events> extractData(final ResultSet resultSet) throws SQLException {

			final List<Events> userEventList = new ArrayList<>();
			while (resultSet.next()) {
				userEventList.add(new EventBuilder()
					.withDescription(resultSet.getString("Description"))
					.withUserId(resultSet.getLong("userId"))
					.withTitle(resultSet.getString("Title"))
					.withDateOfEvent(LocalDate.parse(
						resultSet.getString("dateOfEvent"),
						DateTimeFormatter.ISO_LOCAL_DATE))
					.build());

			}

			return userEventList;
		}
	}
}