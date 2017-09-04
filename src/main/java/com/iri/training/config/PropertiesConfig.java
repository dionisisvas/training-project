package com.iri.training.config;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.crypto.KeyGenerator;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql_queries.properties")
public class PropertiesConfig {

	static Logger logger = Logger.getLogger(PropertiesConfig.class);

	/*
	 * SQL RELATED STATIC FIELDS
	 */
	public static final String SQL_QUERIES_FILE = "./resources/sql_queries.properties";
	// User queries
	public static String GET_USER_BY_ID;
	public static String GET_USER_LIST;
	public static String ADD_USER;
	// Account queries
	public static String GET_ACCOUNT_BY_USERNAME;
	public static String GET_ACCOUNT_BY_ID;
	public static String GET_ACCOUNT_BY_EMAIL;
	public static String GET_ACCOUNT_LIST;
	public static String ADD_ACCOUNT;
	// Image queries
	public static String GET_IMAGE_BY_ID;
	public static String GET_PROFILE_IMAGE_BY_USER_ID;
	public static String GET_IMAGES_BY_USER;
	// Hobby queries
	public static String GET_HOBBY_BY_ID;
	public static String GET_HOBBY_LIST;
	public static String GET_HOBBIES_BY_USER_ID;
	// Comment queries
	public static String GET_COMMENT_BY_ID;
	public static String GET_COMMENTS_BY_SUBJECT_TYPE_AND_ID;
	public static String GET_HOBBIES_BY_POSTER_ID;
	public static String GET_COMMENT_REPLY_BY_ID;
	public static String GET_REPLIES_BY_COMMENT_ID;
	// Metrics queries
	public static String GET_METRICS_BY_USER_ID;
	public static String GET_METRICS_LIST;
	public static String INIT_USER_METRICS;
	// Event queries
	public static String GET_EVENTS_BY_USER_ID;
	public static String GET_EVENT_LIST;

	/*
	 * JWT STATIC FIELDS
	 */
	public static final String JWT_KEY_FILE = "./resources/jwt_key.properties";
	public static Key JWT_KEY;

	@PostConstruct
	public static void load() throws NoSuchAlgorithmException  {

		logger.info("Loading application properties...");

		JWT_KEY = getKey();
		logger.info("JWT key loaded...");

		logger.info("Application properties loading finished.");
	}

	private static Key getKey() throws NoSuchAlgorithmException  {

		logger.info("Generating a new secure JWT signing key...");
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		SecureRandom rand = new SecureRandom();
		keygen.init(256, rand);

		return keygen.generateKey();
	}
}

