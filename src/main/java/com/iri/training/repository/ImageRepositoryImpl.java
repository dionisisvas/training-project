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
import com.iri.training.model.Image;
import com.iri.training.model.builder.ImageBuilder;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

	Logger logger = Logger.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplate;
	private DatabaseConnection dbConnection = new DatabaseConnection();
	private DataSource dataSource = dbConnection .getDataSource();

	@Override
	public Image getImageById(Long imgId) throws SQLException {

		logger.debug("ENTERED getImageById for imgId: " + imgId);

		final Image userImg;

		jdbcTemplate = new JdbcTemplate(dataSource);
		userImg = jdbcTemplate.query(PropertiesConfig.GET_IMAGE_BY_ID,
			new Object[]{imgId},
			new ImageResultSetExtractor());

		logger.debug("EXITING getImageById: " + userImg);
		
		return userImg;
	}

	@Override
	public Image getProfileImage(Long userId) throws SQLException {

		logger.debug("ENTERED getProfileImage for userId: " + userId);

		final Image userProfileImg;

		jdbcTemplate = new JdbcTemplate(dataSource);
		userProfileImg = jdbcTemplate.query(PropertiesConfig.GET_PROFILE_IMAGE_BY_USER_ID,
			new Object[]{userId},
			new ImageResultSetExtractor());

		logger.debug("EXITING getProfileImage: " + userProfileImg);

		return userProfileImg;
	}

	@Override
	public List<Image> getUserImages(Long userId) throws SQLException {

		logger.debug("ENTERED getUserImages");

		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Image> images = jdbcTemplate.query(PropertiesConfig.GET_IMAGES_BY_USER_ID,
			new Object[]{userId},
			new ImageListResultSetExtractor());

		logger.debug("EXITING getUserImages: " + images);

		return images;
	}

	private static final class ImageResultSetExtractor implements ResultSetExtractor<Image> {

		@Override
		public Image extractData(final ResultSet resultSet) throws SQLException {

			final Image img;

			if (resultSet.next()) {
				img = new ImageBuilder()
					.withImageId(resultSet.getLong("imgId"))
					.withUserId(resultSet.getLong("userId"))
					.withIsProfileImage(resultSet.getBoolean("isProfileImg"))
					.withImageUri(resultSet.getString("imgUri"))
					.build();
			}
			else
			{
				return null;
			}

			return img;
		}
	}

	private static final class ImageListResultSetExtractor implements ResultSetExtractor<List<Image>> {

		@Override
		public List<Image> extractData(final ResultSet resultSet) throws SQLException {

			final List<Image> imgList = new ArrayList<>();
			while (resultSet.next()) {
				imgList.add(new ImageBuilder()
					.withImageId(resultSet.getLong("imgId"))
					.withUserId(resultSet.getLong("userId"))
					.withIsProfileImage(resultSet.getBoolean("isProfileImg"))
					.withImageUri(resultSet.getString("imgUri"))
					.build());
			}

			return imgList;
		}
	}
}
