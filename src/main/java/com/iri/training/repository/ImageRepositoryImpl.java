package com.iri.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.iri.training.model.Image;
import com.iri.training.model.builder.ImageBuilder;

@Repository
public class ImageRepositoryImpl implements ImageRepository {
	Logger logger = Logger.getLogger(ImageRepositoryImpl.class);
	
	public Image getImageById(Long imgId) throws SQLException {
		logger.debug("ENTERED getImageById for id " + imgId);
		
		Connection c;
		Statement stmt;

		final Image userImg;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM user_images WHERE imgId = ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, imgId);
			ResultSet resultSet = pst.executeQuery( );

			if(resultSet.next()) {
				userImg = new ImageBuilder()
					.withImageId(resultSet.getLong("imgId"))
					.withUserId(resultSet.getLong("userId"))
					.withIsProfileImage(resultSet.getBoolean("isProfileImg"))
					.withImageUri(resultSet.getString("imgUri"))
					.build();
			}
			else {
				userImg = null;
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
		
		logger.debug("EXITING getImageById for img " + userImg.toString());
		
		return userImg;
	}

	public Image getProfileImage(Long userId) throws SQLException {
		logger.debug("ENTERED getProfileImage for user id " + userId);

		Connection c;
		Statement stmt;

		final Image userImg;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT * FROM user_images WHERE userId = ? AND isProfileImg = 1;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );

			if(resultSet.next()) {
				userImg = new ImageBuilder()
					.withImageId(resultSet.getLong("imgId"))
					.withUserId(resultSet.getLong("userId"))
					.withIsProfileImage(resultSet.getBoolean("isProfileImg"))
					.withImageUri(resultSet.getString("imgUri"))
					.build();
			}
			else
			{
				userImg = null;
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}

		logger.debug("EXITING getProfileImage for user id " + userId);

		return userImg;
	}
	public ArrayList<Image> getUserImages(Long userId) throws SQLException {
		logger.debug("ENTERED ggetUserImages");

		final ArrayList<Image> images = new ArrayList<>();
		Connection c;
		Statement stmt;

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:db\\TrainingApp.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "SELECT imgId, userId, isProfileImg, imgUri FROM user_images WHERE userId = ?;";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setLong(1, userId);
			ResultSet resultSet = pst.executeQuery( );

			while(resultSet.next()) {
				images.add(new ImageBuilder()
					.withImageId(resultSet.getLong("imgId"))
					.withUserId(resultSet.getLong("userId"))
					.withIsProfileImage(resultSet.getBoolean("isProfileImg"))
					.withImageUri(resultSet.getString("imgUri"))
					.build());
			}

			resultSet.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
		
		logger.debug("EXITING getUserImages");
		
		return images;
	}
}
