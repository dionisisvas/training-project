package com.iri.training.config;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {

	static Logger logger = Logger.getLogger(PropertiesConfig.class);

	/*
	 * SQL RELATED STATIC FIELDS
	 */
	public static final String SQL_QUERIES_FILE = "/sql_queries.properties";
	// User queries
	public static String GET_USER_BY_ID;
	public static String GET_USER_LIST;
	public static String ADD_USER;
	// Account queries
	public static String GET_ACCOUNT_BY_ID;
	public static String GET_ACCOUNT_BY_USERNAME;
	public static String GET_ACCOUNT_BY_EMAIL;
	public static String GET_ACCOUNT_LIST;
	public static String ADD_ACCOUNT;
	// Image queries
	public static String GET_IMAGE_BY_ID;
	public static String GET_PROFILE_IMAGE_BY_USER_ID;
	public static String GET_IMAGES_BY_USER_ID;
	// Hobby queries
	public static String GET_HOBBY_BY_ID;
	public static String GET_HOBBY_LIST;
	public static String GET_HOBBIES_BY_USER_ID;
	// Comment queries
	public static String GET_COMMENT_BY_ID;
	public static String GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID;
	public static String GET_COMMENTS_BY_POSTER_ID;
	public static String GET_COMMENT_REPLY_BY_ID;
	public static String GET_COMMENT_REPLIES_BY_PARENT_ID;
	// Metrics queries
	public static String GET_METRICS_BY_USER_ID;
	public static String GET_METRICS_LIST;
	public static String INIT_USER_METRICS;
	// Event queries
	public static String GET_EVENTS_BY_USER_ID;
	public static String GET_EVENT_LIST;
	public static int KEY_LIFETIME_IN_HOURS;

	/*
	 * JWT STATIC FIELDS
	 */
	public static final String JWT_FILE = "/jwt.properties";
	public static SecretKey JWT_KEY;
	public static LocalDateTime KEY_EXPIRY_DATE;

	@PostConstruct
	public static void load() throws NoSuchAlgorithmException {

		logger.info("Loading application properties...");

		try {
			Properties sqlProperties = new Properties();
			final InputStream is = PropertiesConfig.class.getResourceAsStream(SQL_QUERIES_FILE);
			sqlProperties.load(is);
			is.close();

			// User queries
			GET_USER_BY_ID = sqlProperties.getProperty("GET_USER_BY_ID",
				"SELECT * FROM users WHERE userId = ?;");
			GET_USER_LIST = sqlProperties.getProperty("GET_USER_LIST",
				"SELECT userId, name, surname, dob FROM users;");
			ADD_USER = sqlProperties.getProperty("ADD_USER",
				"INSERT INTO users(name, surname, dob) VALUES(?, ?, ?);");

			// Account queries
			GET_ACCOUNT_BY_ID = sqlProperties.getProperty("GET_ACCOUNT_BY_ID",
				"SELECT * FROM accounts WHERE accountId = ?;");
			GET_ACCOUNT_BY_USERNAME = sqlProperties.getProperty("GET_ACCOUNT_BY_USERNAME",
				"SELECT * FROM accounts WHERE username = ?;");
			GET_ACCOUNT_BY_EMAIL = sqlProperties.getProperty("GET_ACCOUNT_BY_EMAIL",
				"SELECT * FROM accounts WHERE email = ?;");
			GET_ACCOUNT_LIST = sqlProperties.getProperty("GET_ACCOUNT_LIST",
				"SELECT accountId, username, email FROM accounts;");
			ADD_ACCOUNT = sqlProperties.getProperty("ADD_ACCOUNT",
				"INSERT INTO accounts(accountId, username, password, email) VALUES(?, ?, ?, ?);");

			// Image queries
			GET_IMAGE_BY_ID = sqlProperties.getProperty("GET_IMAGE_BY_ID",
				"SELECT * FROM user_images WHERE imgId = ?;");
			GET_PROFILE_IMAGE_BY_USER_ID = sqlProperties.getProperty("GET_PROFILE_IMAGE_BY_USER_ID",
				"SELECT * FROM user_images WHERE userId = ? AND isProfileImg = 1;");
			GET_IMAGES_BY_USER_ID = sqlProperties.getProperty("GET_IMAGES_BY_USER_ID",
				"SELECT imgId, userId, isProfileImg, imgUri FROM user_images WHERE userId = ?;");

			// Hobby queries
			GET_HOBBY_BY_ID = sqlProperties.getProperty("GET_HOBBY_BY_ID",
				"SELECT * FROM hobbies WHERE hobbyId = ?;");
			GET_HOBBY_LIST = sqlProperties.getProperty("GET_HOBBY_LIST",
				"SELECT * FROM hobbies;");
			GET_HOBBIES_BY_USER_ID = sqlProperties.getProperty("GET_HOBBIES_BY_USER_ID",
				"SELECT * FROM user_hobbies WHERE userId = ?;");

			// Comment queries
			GET_COMMENT_BY_ID = sqlProperties.getProperty("GET_COMMENT_BY_ID",
				"SELECT * FROM comments WHERE id = ?;");
			GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID = sqlProperties.getProperty("GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID",
				"SELECT id, poster_id, content, creation_date, last_edit_date FROM comments WHERE subject_type = ? AND subject_id = ?;");
			GET_COMMENTS_BY_POSTER_ID = sqlProperties.getProperty("GET_COMMENTS_BY_POSTER_ID",
				"SELECT id, poster_id, subject_type, subject_id, content, creation_date FROM comments WHERE poster_id = ?;");
			GET_COMMENT_REPLY_BY_ID = sqlProperties.getProperty("GET_COMMENT_REPLY_BY_ID",
				"SELECT * FROM comment_replies WHERE id = ?;");
			GET_COMMENT_REPLIES_BY_PARENT_ID = sqlProperties.getProperty("GET_COMMENT_REPLIES_BY_PARENT_ID",
				"SELECT id, poster_id, content, creation_date, last_edit_date FROM comment_replies WHERE parent_id = ?;");

			// Metrics queries
			GET_METRICS_BY_USER_ID = sqlProperties.getProperty("GET_METRICS_BY_USER_ID",
				"SELECT * FROM METRICS WHERE userID = ?;");
			GET_METRICS_LIST = sqlProperties.getProperty("GET_METRICS_LIST",
				"SELECT * FROM METRICS;");
			INIT_USER_METRICS = sqlProperties.getProperty("INIT_USER_METRICS",
				"INSERT INTO METRICS DEFAULT VALUES;");

			// Event queries
			GET_EVENTS_BY_USER_ID = sqlProperties.getProperty("GET_EVENTS_BY_USER_ID",
				"SELECT * FROM USER_SELECTED_DATES WHERE userID = ?");
			GET_EVENT_LIST = sqlProperties.getProperty("GET_EVENT_LIST",
				"SELECT * FROM USER_SELECTED_DATES;");
			logger.info("sql_queries properties loaded...");
		} catch (IOException | NullPointerException e) {
			logger.warn("Loading the sql_queries.properties file failed! " + e);
			System.exit(0);
		}

		try {
			Properties jwtProperties = new Properties();
			final InputStream is = PropertiesConfig.class.getResourceAsStream(JWT_FILE);
			jwtProperties.load(is);
			is.close();

			KEY_LIFETIME_IN_HOURS = Integer.parseInt(jwtProperties.getProperty("KeyLifetimeInHours", "720"));
			generateKey();

			logger.info("JWT properties loaded...");
		} catch (IOException | NullPointerException e) {
			logger.warn("Loading the jwt_key.properties failed! " + e);
			System.exit(0);
		}

		logger.info("Application properties loading finished.");
	}

	public static void generateKey() throws NoSuchAlgorithmException  {

		logger.info("Generating a new secure JWT signing key...");

		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		final SecureRandom rand = new SecureRandom();
		keygen.init(256, rand);

		JWT_KEY = keygen.generateKey();
		KEY_EXPIRY_DATE = LocalDateTime.now().plusHours(KEY_LIFETIME_IN_HOURS);
	}
}

