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
import com.iri.training.enums.EducationLevel;
import com.iri.training.model.Education;
import com.iri.training.model.builder.EducationBuilder;

@Repository
public final class EducationRepositoryImpl implements EducationRepository {

	private static final Logger logger = Logger.getLogger(EducationRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection.getDataSource();
	private JdbcTemplate jdbcTemplate;

	@Override
	public final List<Education> getEducationByUserId(final long userId) throws SQLException {

		logger.debug("ENTERED getEducationByUserId for userId: " + userId);

		final List<Education> userEducation;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userEducation = jdbcTemplate.query(PropertiesConfig.GET_USER_EDUCATION_BY_USER_ID,
			new Object[]{userId},
			new UserEducationResultSetExtractor());

		logger.debug("EXITING getEducationByUserId for userEducation: " + userEducation);

		return userEducation;
	}

	@Override
	public final List<Long> getUsersByEducationLevel(final EducationLevel educationLevel) throws SQLException {

		logger.debug("ENTERED getUsersByEducationLevel for educationLevel: " + educationLevel);

		final List<Long> userIdList;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userIdList = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_USERS_BY_EDUCATION_LEVEL,
			new UserIdListResultSetExtractor()));

		logger.debug("EXITING getUsersByEducationLevel for educationLevel: " + educationLevel);

		return userIdList;
	}

	private static final class UserEducationResultSetExtractor implements ResultSetExtractor<List<Education>> {

		@Override
		public List<Education> extractData(final ResultSet resultSet) throws SQLException {

			final List<Education> userEducation = new ArrayList<>();;

			while (resultSet.next()) {
				userEducation.add(new EducationBuilder()
					.withUserId(resultSet.getLong("user_id"))
					.withSchoolName(resultSet.getString("school_name"))
					.withEducationLevel(EducationLevel.valueOf(resultSet.getString("education_level")))
					.withGraduated(resultSet.getBoolean("graduated"))
					.withDroppedOut(resultSet.getBoolean("dropped_out"))
					.withStartYear(resultSet.getInt("start_year"))
					.withEndYear(resultSet.getInt("end_year"))
					.build());
			}

			return userEducation;
		}
	}

	private static final class UserIdListResultSetExtractor implements ResultSetExtractor<List<Long>> {

		@Override
		public List<Long> extractData(final ResultSet resultSet) throws SQLException {

			final List<Long> userIdList = new ArrayList<>();

			while (resultSet.next()) {
				userIdList.add(resultSet.getLong("user_id"));
			}

			return userIdList;
		}
	}
}
