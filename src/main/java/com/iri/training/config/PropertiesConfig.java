package com.iri.training.config;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.iri.training.util.IRIProperties;

@Component
public class PropertiesConfig {

	private static final Logger logger = Logger.getLogger(PropertiesConfig.class);

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
			IRIProperties sqlProperties = new IRIProperties(SQL_QUERIES_FILE);

			// User queries
			GET_USER_BY_ID = sqlProperties.getProperty("GetUserById",
				"SELECT * FROM users WHERE userId = ?;");
			GET_USER_LIST = sqlProperties.getProperty("GetUserList",
				"SELECT userId, name, surname, dob FROM users;");
			ADD_USER = sqlProperties.getProperty("AddUser",
				"INSERT INTO users(name, surname, dob) VALUES(?, ?, ?);");

			// Account queries
			GET_ACCOUNT_BY_ID = sqlProperties.getProperty("GetAccountById",
				"SELECT * FROM accounts WHERE accountId = ?;");
			GET_ACCOUNT_BY_USERNAME = sqlProperties.getProperty("GetAccountByUsername",
				"SELECT * FROM accounts WHERE username = ?;");
			GET_ACCOUNT_BY_EMAIL = sqlProperties.getProperty("GetAccountByEmail",
				"SELECT * FROM accounts WHERE email = ?;");
			GET_ACCOUNT_LIST = sqlProperties.getProperty("GetAccountList",
				"SELECT accountId, username, email FROM accounts;");
			ADD_ACCOUNT = sqlProperties.getProperty("AddAccount",
				"INSERT INTO accounts(accountId, username, password, email) VALUES(?, ?, ?, ?);");

			// Image queries
			GET_IMAGE_BY_ID = sqlProperties.getProperty("GetImageById",
				"SELECT * FROM user_images WHERE imgId = ?;");
			GET_PROFILE_IMAGE_BY_USER_ID = sqlProperties.getProperty("GetProfileImageByUserId",
				"SELECT * FROM user_images WHERE userId = ? AND isProfileImg = 1;");
			GET_IMAGES_BY_USER_ID = sqlProperties.getProperty("GetImagesByUserId",
				"SELECT imgId, userId, isProfileImg, imgUri FROM user_images WHERE userId = ?;");

			// Hobby queries
			GET_HOBBY_BY_ID = sqlProperties.getProperty("GetHobbyById",
				"SELECT * FROM hobbies WHERE hobbyId = ?;");
			GET_HOBBY_LIST = sqlProperties.getProperty("GetHobbyList",
				"SELECT * FROM hobbies;");
			GET_HOBBIES_BY_USER_ID = sqlProperties.getProperty("GetHobbiesByUserId",
				"SELECT * FROM user_hobbies WHERE userId = ?;");

			// Comment queries
			GET_COMMENT_BY_ID = sqlProperties.getProperty("GetCommentById",
				"SELECT * FROM comments WHERE id = ?;");
			GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID = sqlProperties.getProperty("GetCommentsBySubjectTypeAndId",
				"SELECT id, poster_id, content, creation_date, last_edit_date FROM comments WHERE subject_type = ? AND subject_id = ?;");
			GET_COMMENTS_BY_POSTER_ID = sqlProperties.getProperty("GetCommentsByPosterId",
				"SELECT id, poster_id, subject_type, subject_id, content, creation_date FROM comments WHERE poster_id = ?;");
			GET_COMMENT_REPLY_BY_ID = sqlProperties.getProperty("GetCommentReplyById",
				"SELECT * FROM comment_replies WHERE id = ?;");
			GET_COMMENT_REPLIES_BY_PARENT_ID = sqlProperties.getProperty("GetCommentRepliesByParentId",
				"SELECT id, poster_id, content, creation_date, last_edit_date FROM comment_replies WHERE parent_id = ?;");

			// Metrics queries
			GET_METRICS_BY_USER_ID = sqlProperties.getProperty("GetMetricsByUserId",
				"SELECT * FROM METRICS WHERE userID = ?;");
			GET_METRICS_LIST = sqlProperties.getProperty("GetMetricsList",
				"SELECT * FROM METRICS;");
			INIT_USER_METRICS = sqlProperties.getProperty("InitUserMetrics",
				"INSERT INTO METRICS DEFAULT VALUES;");

			// Event queries
			GET_EVENTS_BY_USER_ID = sqlProperties.getProperty("GetEventsByUserId",
				"SELECT * FROM USER_SELECTED_DATES WHERE userID = ?");
			GET_EVENT_LIST = sqlProperties.getProperty("GetEventList",
				"SELECT * FROM USER_SELECTED_DATES;");
			logger.info("sql_queries properties loaded...");
		} catch (NullPointerException e) {
			logger.warn("Loading the sql_queries.properties file failed! " + e);
			System.exit(0);
		}

		try {
			IRIProperties jwtProperties = new IRIProperties(JWT_FILE);

			KEY_LIFETIME_IN_HOURS = Integer.parseInt(jwtProperties.getProperty("KeyLifetimeInHours", "720"));
			generateJWTSigningKey();

			logger.info("JWT properties loaded...");
		} catch (NullPointerException e) {
			logger.warn("Loading the jwt_key.properties failed! " + e);
			System.exit(0);
		}

		logger.info("Application properties loading finished.");
	}

	public static void generateJWTSigningKey() throws NoSuchAlgorithmException  {

		logger.info("Generating a new secure JWT signing key...");

		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		final SecureRandom rand = new SecureRandom();
		keygen.init(256, rand);

		JWT_KEY = keygen.generateKey();
		KEY_EXPIRY_DATE = LocalDateTime.now().plusHours(KEY_LIFETIME_IN_HOURS);
	}
}

