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
public final class ImageRepositoryImpl implements ImageRepository {

	private static final Logger logger = Logger.getLogger(ImageRepository.class);

	private final DatabaseConnection dbConnection = new DatabaseConnection();
	private final DataSource dataSource = dbConnection .getDataSource();
	private JdbcTemplate jdbcTemplate;

	public final Image getImageById(final long imgId) throws SQLException {

		logger.debug("ENTERED getImageById for imgId: " + imgId);

		final Image userImg;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userImg = jdbcTemplate.query(PropertiesConfig.GET_IMAGE_BY_ID,
			new Object[]{imgId},
			new ImageResultSetExtractor());

		logger.debug("EXITING getImageById with userImg: " + userImg);
		
		return userImg;
	}

	@Override
	public final Image getProfileImage(final long userId) throws SQLException {

		logger.debug("ENTERED getProfileImage for userId: " + userId);

		final Image userProfileImg;
		jdbcTemplate = new JdbcTemplate(dataSource);

		userProfileImg = jdbcTemplate.query(PropertiesConfig.GET_PROFILE_IMAGE_BY_USER_ID,
			new Object[]{userId},
			new ImageResultSetExtractor());

		logger.debug("EXITING getProfileImage with userProfileImg: " + userProfileImg);

		return userProfileImg;
	}

	@Override
	public final List<Image> getUserImages(final long userId) throws SQLException {

		logger.debug("ENTERED getUserImages for userId: " + userId);

		final List<Image> images;
		jdbcTemplate = new JdbcTemplate(dataSource);

		images = new ArrayList<>(jdbcTemplate.query(PropertiesConfig.GET_IMAGES_BY_USER_ID,
			new Object[]{userId},
			new ImagesResultSetExtractor()));

		logger.debug("EXITING getUserImages for userId: " + userId);

		return images;
	}

	@Override
	public final void addImage(final Image image) throws SQLException {

		logger.debug("ENTERED addImage for image: " + image);

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(PropertiesConfig.ADD_IMAGE,
			image.getUserId(),
			image.isProfileImg(),
			image.getImgUri());

		logger.debug("EXITING addImage for image: " + image);
	}

	@Override
	public final void deleteImage(final Image image) throws SQLException {

		logger.debug("ENTERED deleteImage for image: " + image);

		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(PropertiesConfig.DELETE_IMAGE,
			image.getImgUri());

		logger.debug("EXITING deleteImage for image: " + image);
	}

	private static final class ImageResultSetExtractor implements ResultSetExtractor<Image> {

		@Override
		public Image extractData(final ResultSet resultSet) throws SQLException {

			final Image img;

			if (resultSet.next()) {
				img = new ImageBuilder()
					.withImageId(resultSet.getLong("id"))
					.withUserId(resultSet.getLong("user_id"))
					.withIsProfileImage(resultSet.getBoolean("is_profile_img"))
					.withImageUri(resultSet.getString("img_uri"))
					.build();
			}
			else {
				return null;
			}

			return img;
		}
	}

	private static final class ImagesResultSetExtractor implements ResultSetExtractor<List<Image>> {

		@Override
		public List<Image> extractData(final ResultSet resultSet) throws SQLException {

			final List<Image> imgList = new ArrayList<>();

			while (resultSet.next()) {
				imgList.add(new ImageBuilder()
					.withImageId(resultSet.getLong("id"))
					.withUserId(resultSet.getLong("user_id"))
					.withIsProfileImage(resultSet.getBoolean("is_profile_img"))
					.withImageUri(resultSet.getString("img_uri"))
					.build());
			}

			return imgList;
		}
	}
}
