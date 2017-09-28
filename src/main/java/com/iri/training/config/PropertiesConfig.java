package com.iri.training.config;

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
	// Post queries
	public static String GET_POST_BY_ID;
	public static String GET_POSTS_BY_SUBJECT_TYPE_AND_ID;
	public static String GET_POSTS_BY_POSTER_ID;
	// Comment queries
	public static String GET_COMMENT_BY_ID;
	public static String GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID;
	// Metrics queries
	public static String GET_METRICS_BY_USER_ID;
	public static String GET_METRICS_LIST;
	public static String INIT_USER_METRICS;
	// Event queries
	public static String GET_EVENTS_BY_USER_ID;
	public static String GET_EVENT_LIST;
	public static int KEY_LIFETIME_IN_HOURS;
	// User education queries
	public static String GET_USER_EDUCATION_BY_USER_ID;
	public static String GET_USERS_BY_EDUCATION_LEVEL;

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
			GET_USER_BY_ID = sqlProperties.getString("GetUserById",
				"SELECT * FROM users WHERE id = ?;");
			GET_USER_LIST = sqlProperties.getString("GetUserList",
				"SELECT id, name, surname, date_of_birth FROM users;");
			ADD_USER = sqlProperties.getString("AddUser",
				"INSERT INTO users(name, surname, date_of_birth) VALUES(?, ?, ?);");

			// Account queries
			GET_ACCOUNT_BY_ID = sqlProperties.getString("GetAccountById",
				"SELECT * FROM accounts WHERE id = ?;");
			GET_ACCOUNT_BY_USERNAME = sqlProperties.getString("GetAccountByUsername",
				"SELECT * FROM accounts WHERE username = ?;");
			GET_ACCOUNT_BY_EMAIL = sqlProperties.getString("GetAccountByEmail",
				"SELECT * FROM accounts WHERE email = ?;");
			GET_ACCOUNT_LIST = sqlProperties.getString("GetAccountList",
				"SELECT id, username, email, join_date FROM accounts;");
			ADD_ACCOUNT = sqlProperties.getString("AddAccount",
				"INSERT INTO accounts(id, username, password, email, join_date) VALUES(?, ?, ?, ?, ?);");

			// Image queries
			GET_IMAGE_BY_ID = sqlProperties.getString("GetImageById",
				"SELECT * FROM user_images WHERE id = ?;");
			GET_PROFILE_IMAGE_BY_USER_ID = sqlProperties.getString("GetProfileImageByUserId",
				"SELECT * FROM user_images WHERE user_id = ? AND is_profile_img = 1;");
			GET_IMAGES_BY_USER_ID = sqlProperties.getString("GetImagesByUserId",
				"SELECT * FROM user_images WHERE user_id = ?;");

			// Hobby queries
			GET_HOBBY_BY_ID = sqlProperties.getString("GetHobbyById",
				"SELECT * FROM hobbies WHERE id = ?;");
			GET_HOBBY_LIST = sqlProperties.getString("GetHobbyList",
				"SELECT * FROM hobbies;");
			GET_HOBBIES_BY_USER_ID = sqlProperties.getString("GetHobbiesByUserId",
				"SELECT * FROM user_hobbies WHERE user_id = ?;");

			// Post queries
			GET_POST_BY_ID = sqlProperties.getString("GetPostById",
				"SELECT * FROM posts WHERE id = ?;");
			GET_POSTS_BY_SUBJECT_TYPE_AND_ID = sqlProperties.getString("GetPostsBySubjectTypeAndId",
				"SELECT id, poster_id, title, content, creation_date, last_edit_date FROM posts WHERE subject_type = ? AND subject_id = ?;");
			GET_POSTS_BY_POSTER_ID = sqlProperties.getString("GetPostsByPosterId",
				"SELECT * FROM posts WHERE poster_id = ?;");

			// Comment queries
			GET_COMMENT_BY_ID = sqlProperties.getString("GetCommentById",
				"SELECT * FROM comments WHERE id = ?;");
			GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID = sqlProperties.getString("GetCommentsBySubjectTypeAndId",
				"SELECT id, poster_id, content, creation_date, last_edit_date FROM comments WHERE subject_type = ? AND subject_id = ?;");

			// Metrics queries
			GET_METRICS_BY_USER_ID = sqlProperties.getString("GetMetricsByUserId",
				"SELECT * FROM METRICS WHERE userID = ?;");
			GET_METRICS_LIST = sqlProperties.getString("GetMetricsList",
				"SELECT * FROM METRICS;");
			INIT_USER_METRICS = sqlProperties.getString("InitUserMetrics",
				"INSERT INTO METRICS DEFAULT VALUES;");

			// Event queries
			GET_EVENTS_BY_USER_ID = sqlProperties.getString("GetEventsByUserId",
				"SELECT * FROM USER_SELECTED_DATES WHERE userID = ?");
			GET_EVENT_LIST = sqlProperties.getString("GetEventList",
				"SELECT * FROM USER_SELECTED_DATES;");

			// User education queries
			GET_USER_EDUCATION_BY_USER_ID = sqlProperties.getString("GetUserEducationByUserId",
				"SELECT * FROM user_education WHERE user_id = ?;");
			GET_USERS_BY_EDUCATION_LEVEL = sqlProperties.getString("GetUsersByEducationLevel",
				"SELECT user_id FROM user_education WHERE education_level = ?;");

			logger.info("sql_queries properties loaded...");
		} catch (NullPointerException e) {
			logger.warn("Loading the sql_queries.properties file failed! " + e);
			System.exit(0);
		}

		try {
			IRIProperties jwtProperties = new IRIProperties(JWT_FILE);

			KEY_LIFETIME_IN_HOURS = jwtProperties.getInt("KeyLifetimeInHours", 720);
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

